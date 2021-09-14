package no.kristiania.exam.website.website.backend.Service;

import no.kristiania.exam.website.website.backend.StubApplication;
import no.kristiania.exam.website.website.backend.entity.Item;
import no.kristiania.exam.website.website.backend.service.ItemService;
import no.kristiania.exam.website.website.backend.service.RankService;
import no.kristiania.exam.website.website.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * The tests are inspired from the course repo
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/backend/src/test/java/org/tsdes/intro/exercises/quizgame/backend/service
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StubApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ItemServiceTest extends ServiceTestBase{

    @Autowired
    private ItemService itemService;

    @Autowired
    private RankService rankService;

    @Autowired
    private UserService userService;

    @Test
    public void testNoItem(){
        List<Item> list = itemService.getAllItems(false);
        assertEquals(0, list.size());
    }

    @Test
    public void testCreateItem(){
        Long id = itemService.createItem("Testing", "Testing description", "Testing sports");
        assertNotNull(id);
    }
    @Test
    public void testSortByCategory(){
        Long itemOne = itemService.createItem("Testing", "Testing description", "Bar sports");
        Long itemTwo = itemService.createItem("Testing 2", "Testing description2", "Bar sports");
        Long itemThree = itemService.createItem("Testing 3", "Testing description3", "Foo sports");

        List<Item> barItems = itemService.sortByCategory("Bar sports");
        List<Item> fooItems = itemService.sortByCategory("Foo sports");
        assertEquals(1, fooItems.size());
        assertEquals(2, barItems.size());
    }

    @Test
    public void testGetAllItems(){
        Long itemOne = itemService.createItem("Testing", "Testing description", "Bar sports");
        Long itemTwo = itemService.createItem("Testing 2", "Testing description2", "Bar sports");
        Long itemThree = itemService.createItem("Testing 3", "Testing description3", "Foo sports");
        List<Item> items = itemService.getAllItems(false);
        assertEquals(3, items.size());
    }
    @Test
    public void testGetItem(){
        Long itemOne = itemService.createItem("Testing", "Testing description", "Testing sports");
        Item item = itemService.getItem(itemOne, false);
        assertEquals(itemOne, item.getId());
    }
    @Test
    public void testComputeAvgFromItem(){
        String userOne = "test123";
        String userTwo = "foo123";
        String userThree = "bar123";

        userService.createUser(userOne, "test1", "bar1","test1@bar1.com", "123");
        userService.createUser(userTwo, "test2", "bar2","test2@bar2.com", "123");
        userService.createUser(userThree, "test3", "bar3","test3@bar3.com", "123");

        Long itemOne = itemService.createItem("test title", "testing desc", "test ctg");
        Long rank1 = rankService.createRank(itemOne,userOne,3, "Test comment1");
        Long rank2 = rankService.createRank(itemOne,userTwo,4, "Test comment2");
        Long rank3 = rankService.createRank(itemOne,userThree,5, "Test comment3");

        assertNotNull(rank1);
        assertNotNull(rank2);
        assertNotNull(rank3);
        assertEquals(4.0, itemService.computeAvgRatingByUsers(itemService.getItem(itemOne)));


        //Test if the code can handle multiple items

        Long itemTwo = itemService.createItem("test title", "testing desc", "test ctg");
        Long rank4 = rankService.createRank(itemTwo,userOne,1,"Test comment1");
        Long rank5 = rankService.createRank(itemTwo,userTwo,2, "Test comment2");
        Long rank6 = rankService.createRank(itemTwo,userThree,3, "Test comment3");
        assertNotNull(rank4);
        assertNotNull(rank5);
        assertNotNull(rank6);

        assertEquals(2.0, itemService.computeAvgRatingByUsers(itemService.getItem(itemTwo)));

    }
}

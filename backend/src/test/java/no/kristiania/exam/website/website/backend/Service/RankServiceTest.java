package no.kristiania.exam.website.website.backend.Service;

import no.kristiania.exam.website.website.backend.StubApplication;
import no.kristiania.exam.website.website.backend.service.ItemService;
import no.kristiania.exam.website.website.backend.service.RankService;
import no.kristiania.exam.website.website.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The tests are inspired from the course repo
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/backend/src/test/java/org/tsdes/intro/exercises/quizgame/backend/service
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StubApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RankServiceTest extends ServiceTestBase{

    @Autowired
    private RankService rankService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Test
    public void testCreateRank(){
        userService.createUser("test123", "test", "bar","test@bar.com", "123");
        Long itemOne = itemService.createItem("test title", "testing desc", "test ctg");
        Long rank1 = rankService.createRank(itemOne,"test123",4, "Test comment");
        assertNotNull(rank1);
    }

    @Test
    public void testUpdateRankAndComment(){
        String userOne = "test123";
        userService.createUser(userOne, "test1", "bar1","test1@bar1.com", "123");
        Long itemOne = itemService.createItem("test title", "testing desc", "test ctg");
        Long rank1 = rankService.createRank(itemOne,userOne,3, "Testing comment");
        assertNotNull(rank1);

        rankService.updateRankAndComment(rank1, 5, "Testing comment");
    }

    @Test
    public void testCommentOnRank(){
        String userOne = "test123";
        userService.createUser(userOne, "test1", "bar1","test1@bar1.com", "123");
        Long itemOne = itemService.createItem("test title", "testing desc", "test ctg");
        Long rank1 = rankService.createRank(itemOne,userOne,3, "Test comment");
        assertNotNull(rank1);

        rankService.commentOnRank(rank1,"Is this testing comment?");
    }
}

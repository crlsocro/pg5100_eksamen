package no.kristiania.exam.website.website.backend.Service;

import no.kristiania.exam.website.website.backend.StubApplication;
import no.kristiania.exam.website.website.backend.service.ItemService;
import no.kristiania.exam.website.website.backend.service.RankService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_CLASS;

/**
 * Adapted from course repo:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/backend/src/test/java/org/tsdes/intro/exercises/quizgame/backend/service
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StubApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = BEFORE_CLASS)
public class DefaultDataInitializerServiceTest {
   @Autowired
    private ItemService itemService;

    @Autowired
    private RankService rankService;

    @Test
    public void testInit() {

        assertTrue(rankService.getRanks().size() > 0);

        assertTrue(itemService.getAllItems(false).size() > 0);

        assertTrue(itemService.getAllItems(true).stream()
                .mapToLong(i -> i.getAuthorsRanked().size())
                .sum() > 0);
    }
}

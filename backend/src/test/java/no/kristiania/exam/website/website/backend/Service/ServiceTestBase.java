package no.kristiania.exam.website.website.backend.Service;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Adapted from course repo:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/backend/src/test/java/org/tsdes/intro/exercises/quizgame/backend/service
 */


public class ServiceTestBase {

    @Autowired
    private ResetService deleteService;


    @BeforeEach
    public void cleanDatabase(){
        deleteService.resetDatabase();
    }
}

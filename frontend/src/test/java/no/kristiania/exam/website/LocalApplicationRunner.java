package no.kristiania.exam.website;

import org.springframework.boot.SpringApplication;


/**
 * Adapted from course repo:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/frontend/src
 */

public class LocalApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, "--spring.profiles.active=test");
    }
}
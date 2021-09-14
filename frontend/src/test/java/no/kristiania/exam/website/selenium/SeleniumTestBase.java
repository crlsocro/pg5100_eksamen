package no.kristiania.exam.website.selenium;

import org.openqa.selenium.WebDriver;

/**
 * Adapted and inspired from course repo:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/frontend/src/test/java/org/tsdes/intro/exercises/quizgame
 */

public abstract class SeleniumTestBase {


    protected abstract WebDriver getDriver();

    protected abstract String getServerHost();

    protected abstract int getServerPort();
}

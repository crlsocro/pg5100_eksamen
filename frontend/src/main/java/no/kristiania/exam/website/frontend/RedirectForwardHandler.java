package no.kristiania.exam.website.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Adapted from course repo:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/frontend/src
 */

@Controller
public class RedirectForwardHandler {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String forward(){
        return "forward:index.xhtml";
    }
}

package no.kristiania.exam.website.frontend.controller;

import no.kristiania.exam.website.website.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Adapted from course repo:
 * https://github.com/arcuri82/testing_security_development_enterprise_systems/tree/master/intro/exercise-solutions/quiz-game/part-11/frontend/src
 */

@Named
@RequestScoped
public class UserInfoController {

    @Autowired
    private UserService userService;

    public String getUserName(){
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }


}
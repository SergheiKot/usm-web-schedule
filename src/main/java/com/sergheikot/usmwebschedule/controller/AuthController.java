package com.sergheikot.usmwebschedule.controller;

import com.sergheikot.usmwebschedule.jpa.domain.Session;
import com.sergheikot.usmwebschedule.jpa.domain.User;
import com.sergheikot.usmwebschedule.jpa.repository.Repositories;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("auth")
public class AuthController extends Repositories {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String SESSION_KEY = "sessionKey";

    @PostMapping
    public String signIn(@RequestBody Map<String, String> requestBody) {

        User user = getUserRepository()
                .findByLoginAndPassword(requestBody.get(LOGIN), requestBody.get(PASSWORD))
                .get(0);

        Session session = new Session();
        session.setUser(user);

        session.setKey(UUID.randomUUID().toString());

        session = getSessionRepository().save(session);

        return SESSION_KEY + ": " + session.getKey();
    }

    @DeleteMapping
    public void signOut(@RequestBody Map<String, String> requestBody) {

        getSessionRepository().delete(getSessionRepository()
                .findByKey(requestBody.get(SESSION_KEY))
                .get(0));
    }

}

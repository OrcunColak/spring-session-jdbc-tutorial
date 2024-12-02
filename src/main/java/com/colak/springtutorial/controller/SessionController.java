package com.colak.springtutorial.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RestController
class SessionController {

    // http://localhost:8080/set-session
    @GetMapping("/set-session")
    public String setSession(HttpSession session) {
        session.setAttribute("username", "John Doe");
        return "Session attribute 'username' set!";
    }

    // http://localhost:8080/get-session
    @GetMapping("/get-session")
    public String getSession() {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        String username = (String) session.getAttribute("username");
        return "Session username: " + username;
    }
}

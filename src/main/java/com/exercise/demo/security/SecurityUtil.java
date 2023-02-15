package com.exercise.demo.security;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {
    public static String getSessionUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // get current user authentication
        if (!(authentication instanceof AnonymousAuthenticationToken)) {    // if user is authenticated
            String login = authentication.getName();    // return its username
            return login;
        }
        return null;
    }
    
}

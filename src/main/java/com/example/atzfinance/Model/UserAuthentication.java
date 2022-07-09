package com.example.atzfinance.Model;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class UserAuthentication implements AuthenticationProvider {

    final User[] USER_DATABASE = {
        new User("Bob", "password")
    };

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        for (User user : USER_DATABASE) {
            if (user.getUsername().equals(authentication.getName()) &&
                user.getPassword().equals(authentication.getCredentials().toString())) {
                    return new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword(), user.getAuthorities());
                }
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

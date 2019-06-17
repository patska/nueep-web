package com.pi.nueep.config;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
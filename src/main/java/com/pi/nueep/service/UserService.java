package com.pi.nueep.service;


import com.pi.nueep.entidades.sistema.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
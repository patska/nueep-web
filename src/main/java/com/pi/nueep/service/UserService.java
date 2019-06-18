package com.pi.nueep.service;


import com.pi.nueep.entidades.sistema.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    public List<User> encontrarTodos();
    public void deletarPorId(User user);

}
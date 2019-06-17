package com.pi.nueep.dao;


import com.pi.nueep.entidades.sistema.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

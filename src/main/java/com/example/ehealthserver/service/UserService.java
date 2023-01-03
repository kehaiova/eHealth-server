package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUsernameAndPassword(String username, String password) throws Exception;

    Optional<User> findByEmail(String email);

    Optional<User> findByUinDoctor(String uinDoctor);

    User updateUser(Long id, User user) throws Exception;
}

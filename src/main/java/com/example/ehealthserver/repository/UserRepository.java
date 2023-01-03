package com.example.ehealthserver.repository;

import com.example.ehealthserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);
    public Optional<User> findByUsernameAndPassword(String username, String password) throws Exception;
    public Optional<User> findByUinDoctor(String uinDoctor);
    public Optional<User> getByUsername(String username);
    public Optional<User> findByEmail(String email);

}

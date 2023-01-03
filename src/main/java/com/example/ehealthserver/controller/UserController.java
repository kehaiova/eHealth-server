package com.example.ehealthserver.controller;

import com.example.ehealthserver.entity.User;
import com.example.ehealthserver.repository.UserRepository;
import com.example.ehealthserver.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {


    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody @Validated User user) {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            if (userService.findByEmail(user.getEmail()).isEmpty()) {
                if (userService.findByUinDoctor(user.getUinDoctor()).isEmpty()) {
                    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
                    String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
                    user.setPassword(encodedPassword);
                    userRepository.save(user);
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Doctor with this UIN already exist!");
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exist!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username already exist!");
        }
        return user;
    }

    @GetMapping("/login/{username}/{password}")
    public Optional<User> findByUsernameAndPassword(@PathVariable String username, @PathVariable String password) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            String encodedPassword = user.getPassword();
            if (bCryptPasswordEncoder.matches(String.valueOf(password), encodedPassword)) {
                return userService.findByUsernameAndPassword(username, encodedPassword);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findByEmail/{email}")
    public Optional<User> findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) throws Exception {
        user.setId(id);
        String username = String.valueOf(userRepository.findByUsername(user.getUsername()));
        String email = String.valueOf(userRepository.findByEmail(user.getEmail()));
        Long currentId = userRepository.findByUsername(user.getUsername()).getId();
        if (userRepository.existsById(id)) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            if (username == null || !currentId.equals(id)) {
                if (email.isEmpty() || !currentId.equals(id)) {
                    user.setUsername(username);
                    user.setEmail(email);
                    return ResponseEntity.ok().body(userService.updateUser(id, user));
                } else {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exist!");
                }
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Username already exist!");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User with this id not found");
        }
    }
}

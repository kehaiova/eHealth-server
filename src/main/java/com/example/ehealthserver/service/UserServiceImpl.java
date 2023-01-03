package com.example.ehealthserver.service;

import com.example.ehealthserver.entity.User;
import com.example.ehealthserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) throws Exception {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUinDoctor(String uinDoctor) {
        return userRepository.findByUinDoctor(uinDoctor);
    }

    @Override
    public User updateUser(final Long id, final User user) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userUpdate = userOptional.get();
            userUpdate.setPassword(user.getPassword());
            userUpdate.setUsername(user.getUsername());
            userUpdate.setEmail(user.getEmail());
            userRepository.save(userUpdate);
            return userUpdate;
        } else {
            throw new Exception("Record not found with id" + user.getId());
        }
    }

}

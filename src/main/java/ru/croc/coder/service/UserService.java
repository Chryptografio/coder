package ru.croc.coder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.User;
import ru.croc.coder.repository.UserRepository;

import java.util.List;

/**
 * todo Document type UserService
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> list() {
        return userRepository.findAll();
    }
}

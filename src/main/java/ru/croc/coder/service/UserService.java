package ru.croc.coder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Role;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.RegisteringUserDto;
import ru.croc.coder.repository.UserRepository;

import javax.transaction.Transactional;
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

    @Transactional
    public User registerNewUser(RegisteringUserDto newUser) throws UserAlreadyExistException {
        if (emailExist(newUser.getEmail())) {
            throw new UserAlreadyExistException("User with such email already exists");
        }

        User user = new User()
            .setFirstName(newUser.getFirstName())
            .setLastName(newUser.getLastName())
            .setRole(Role.STUDENT)
            .setEmail(newUser.getEmail())
            .setPassword(newUser.getPassword());
        return userRepository.save(user);
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}

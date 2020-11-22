package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Role;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.RegisterUserDto;
import ru.croc.coder.dto.UserDto;
import ru.croc.coder.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

// TODO add registering and authentication
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Set<UserDto> list() {

        Iterable<User> userIterable = userRepository.findAll();
        return StreamSupport.stream(userIterable.spliterator(), false)
            .map(user -> modelMapper.map(user, UserDto.class))
            .collect(Collectors.toSet());
    }

    @Transactional
    public UserDto register(RegisterUserDto newUser) throws UserAlreadyExistException {
        if (emailExist(newUser.getEmail())) {
            throw new UserAlreadyExistException("User with such email already exists");
        }

        User user = new User()
            .setFirstName(newUser.getFirstName())
            .setLastName(newUser.getLastName())
            .setRole(Role.STUDENT)
            .setEmail(newUser.getEmail())
            .setPassword(newUser.getPassword());
        User registeredUser = userRepository.save(user);

        return modelMapper.map(registeredUser, UserDto.class);
    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}

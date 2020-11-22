package ru.croc.coder.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Role;
import ru.croc.coder.domain.User;
import ru.croc.coder.dto.RegisterUserDto;
import ru.croc.coder.dto.UserDto;
import ru.croc.coder.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public Set<UserDto> list() {
        Iterable<User> userIterable = userRepository.findAll();
        return StreamSupport.stream(userIterable.spliterator(), false)
            .map(user -> modelMapper.map(user, UserDto.class))
            .collect(Collectors.toSet());
    }

    public UserDto getUser(String username) {
        log.info("Provided username: {}", username);

        Optional<User> foundUser = userRepository.findByEmail(username);
        log.info("Found user email: {}", foundUser.get().getEmail());
        return modelMapper.map(foundUser.get(), UserDto.class);
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

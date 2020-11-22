package ru.croc.coder.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.croc.coder.repository.UserRepository;
import ru.croc.coder.security.ApplicationUserRole;

import java.util.Optional;

@Repository("dummy")
@AllArgsConstructor
public class DummyApplicationUserDaoImpl implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return userRepository.findAll().stream()
            .filter(user -> username.equals(user.getEmail()))
            .findFirst()
            .map(user -> new ApplicationUser(
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                ApplicationUserRole.valueOf(user.getRole().toString()).getGrantedAuthorities(),
                true,
                true,
                true,
                true
            ));
    }
}

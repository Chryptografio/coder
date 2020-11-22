package ru.croc.coder.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static ru.croc.coder.security.ApplicationUserRole.AUTHOR;
import static ru.croc.coder.security.ApplicationUserRole.STUDENT;

@Repository("fake")
@AllArgsConstructor
public class FakeApplicationUserDaoImpl implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream()
            .filter(applicationUser -> username.equals(applicationUser.getUsername()))
            .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        return List.of(
            new ApplicationUser(
                "annasmith",
                passwordEncoder.encode("password"),
                STUDENT.getGrantedAuthorities(),
                true,
                true,
                true,
                true),
            new ApplicationUser(
                "linda",
                passwordEncoder.encode("password123"),
                AUTHOR.getGrantedAuthorities(),
                true,
                true,
                true,
                true)
        );
    }
}

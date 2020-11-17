package ru.croc.coder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.croc.coder.domain.Role;
import ru.croc.coder.domain.User;
import ru.croc.coder.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * todo Document type MyUserDetailsService
 */
@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
    UserRepository userRepository;

    @Autowired
    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User with such email not found"));
        boolean enabled = true;
        boolean accountNotExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new org.springframework.security.core.userdetails.User(
            user.getEmail(),
            user.getPassword(),
            enabled,
            accountNotExpired,
            credentialsNonExpired,
            accountNonLocked,
            getAuthorities(user.getRole())
        );
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.toString()));
    }
}

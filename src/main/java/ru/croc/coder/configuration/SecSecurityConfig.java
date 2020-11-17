package ru.croc.coder.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import ru.croc.coder.configuration.security.CustomAuthenticationFailureHandler;
import ru.croc.coder.configuration.security.CustomLogoutSuccessHandler;
import ru.croc.coder.service.MyUserDetailsService;

/**
 * todo Document type SecSecurityConfig
 */
@Configuration
@EnableWebSecurity
@Profile("!https")
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    public SecSecurityConfig() {
        super();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/anonymous*").anonymous()
            .antMatchers("/login*").permitAll()
            .antMatchers("/signup*").permitAll()
            .antMatchers("/problems*").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/perform_login")
            .defaultSuccessUrl("/homepage", true)
            .failureUrl("/login?error=true")
            .failureHandler(authenticationFailureHandler())
            .and()
            .logout()
            .logoutUrl("/perform_logout")
            .deleteCookies("JSESSIONID")
            .logoutSuccessHandler(logoutSuccessHandler());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new CustomLogoutSuccessHandler();
    }
}

package ru.croc.coder.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo think about moving this to configuration repository
 */
@Configuration
public class RepositoryConfiguration {
    public RepositoryConfiguration(){
        super();
    }

    @Bean
    UserEventHandler userEventHandler() {
        return new UserEventHandler();
    }
}

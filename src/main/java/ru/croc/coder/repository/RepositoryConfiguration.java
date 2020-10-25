package ru.croc.coder.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo Document type RepositoryConfiguration
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

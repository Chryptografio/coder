package ru.croc.coder.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * todo Document type DtoConfiguration
 */
@Configuration
public class DtoConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
package com.example.financemanagement.config;

import com.example.financemanagement.dto.UserDTO;
import com.example.financemanagement.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Configuración para mapear 'username' a 'name'
        modelMapper.createTypeMap(UserDTO.class, User.class)
                .addMapping(UserDTO::getUsername, User::setName);
        return modelMapper;
    }
}

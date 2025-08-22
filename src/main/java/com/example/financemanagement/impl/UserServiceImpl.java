// Código completo del servicio
package com.example.financemanagement.impl;

import com.example.financemanagement.dto.UserDTO;
import com.example.financemanagement.entity.User;
import com.example.financemanagement.exceptions.CustomException;
import com.example.financemanagement.repository.UserRepository;
import com.example.financemanagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()) != null) {
            throw new CustomException("Email already exists");
        }
        User user = modelMapper.map(userDTO, User.class);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long id) {
        // Lógica para obtener un usuario por ID.
        return null;
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        // 1. Encuentra el usuario existente.
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CustomException("User not found with id: " + userId));

        // 2. Actualiza los campos que vienen del DTO.
        user.setName(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        // 3. Establece la fecha de actualización justo antes de guardar.
        user.setUpdatedAt(LocalDateTime.now());

        // 4. Guarda los cambios y retorna el DTO actualizado.
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    public boolean deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new CustomException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
        return true;
    }
}
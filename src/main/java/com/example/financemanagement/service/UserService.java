package com.example.financemanagement.service;

import com.example.financemanagement.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long userId, UserDTO userDTO);
    boolean deleteUser(Long userId);

    // Agrega esta línea
    UserDTO getUserById(Long id);
}
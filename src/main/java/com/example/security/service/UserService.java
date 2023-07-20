package com.example.security.service;

import com.example.security.domain.User;
import com.example.security.dto.UserDTO;

import java.util.Set;

public interface UserService {
    User findByUsername(String username);

    UserDTO create(User user);

    Set<UserDTO> getAll();

    UserDTO update(Long id, UserDTO userDTO);

    void delete(Long id);
}

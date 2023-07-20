package com.example.security.service.impl;

import com.example.security.domain.User;
import com.example.security.dto.UserDTO;
import com.example.security.exception.ResourceNotFoundException;
import com.example.security.exception.ResourcesAlreadyExistsException;
import com.example.security.mapper.UserMapper;
import com.example.security.repository.UserRepository;
import com.example.security.service.RoleService;
import com.example.security.service.UserService;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import static com.example.security.constants.SecurityConstants.DEFAULT_ROLE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String ID = "id";

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UserDTO create(User user) {
        user.setRoles(Set.of(roleService.getByName(DEFAULT_ROLE)));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ResourcesAlreadyExistsException();
        }

        User saved = userRepository.save(user);
        return userMapper.toDTO(saved);

    }

    @Override
    public Set<UserDTO> getAll() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toSet());
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        User userFromDB = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        BeanUtils.copyProperties(userMapper.toEntity(userDTO), userFromDB, ID);
        User user = userRepository.save(userFromDB);
        return userMapper.toDTO(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        userRepository.delete(user);
    }
}

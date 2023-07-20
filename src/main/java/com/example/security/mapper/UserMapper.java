package com.example.security.mapper;

import com.example.security.domain.User;
import com.example.security.dto.RegistrationRequest;
import com.example.security.dto.UserDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMapper {
    private final ModelMapper mapper;

    public UserDTO toDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    public User registrationRequestToEntity(RegistrationRequest registrationRequest) {
        return mapper.map(registrationRequest, User.class);
    }
}

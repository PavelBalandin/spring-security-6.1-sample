package com.example.security.mapper;

import com.example.security.domain.Role;
import com.example.security.dto.RoleDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleMapper {
    private final ModelMapper mapper;

    public RoleDTO toDTO(Role role) {
        return mapper.map(role, RoleDTO.class);
    }

    public Role toEntity(RoleDTO roleDTO) {
        return mapper.map(roleDTO, Role.class);
    }
}

package com.example.security.service;

import com.example.security.domain.Role;
import com.example.security.dto.RoleDTO;

import java.util.Set;

public interface RoleService {

    Role getByName(String name);

    Set<RoleDTO> getAll();

    RoleDTO create(RoleDTO roleDTO);

    RoleDTO update(Long id, RoleDTO roleDTO);

    void delete(Long id);
}

package com.example.security.controller;

import com.example.security.dto.RoleDTO;
import com.example.security.service.RoleService;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/roles")
@RequiredArgsConstructor
@PreAuthorize("isAuthenticated()")
public class RoleController {
    private final RoleService roleService;

    @GetMapping
    public ResponseEntity<Set<RoleDTO>> getAll() {
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(roleService.create(roleService.create(roleDTO)), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RoleDTO> update(@PathVariable("id") Long id, @RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(roleService.update(id, roleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoleDTO> delete(@PathVariable("id") Long id) {
        roleService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

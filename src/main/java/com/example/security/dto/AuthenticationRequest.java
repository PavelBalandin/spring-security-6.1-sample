package com.example.security.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {
    @NotBlank(message = "password required")
    @Size(min = 2, max = 30)
    private String username;
    @NotBlank(message = "username required")
    @Size(min = 6, max = 30)
    private String password;
}

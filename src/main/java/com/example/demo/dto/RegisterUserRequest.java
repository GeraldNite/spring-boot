package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RegisterUserRequest {

    @Email
    @NotBlank(message = "email required")
    private String email;

    @NotBlank(message = "name required")
    private String name;

    @NotBlank(message = "password required")
    private String password;

}

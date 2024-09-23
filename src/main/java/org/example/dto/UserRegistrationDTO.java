package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import javax.management.relation.Role;

@Getter
@Setter
public class UserRegistrationDTO {
    private Long userId;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;

}
package com.athletept.athletept.user.dto;

import com.athletept.athletept.user.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserDto {

    private Role role;
    private String name;
    private String email;
    private String password;
    private Instant createdAt;
}

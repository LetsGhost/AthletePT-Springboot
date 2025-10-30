package com.athletept.athletept.user.entity;

import com.athletept.athletept.commons.entity.BaseEntity;
import com.athletept.athletept.user.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    // store a HASH here; never plain text
    @Column(nullable = false)
    private String password;
}

package com.athletept.athletept.user.entity;

import com.athletept.athletept.commons.entity.BaseEntity;
import com.athletept.athletept.user.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    private Role role;
    private String name;
    private String email;
    private String password;
}

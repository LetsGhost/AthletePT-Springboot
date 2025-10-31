package com.athletept.athletept.user.service;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.entity.UserEntity;
import com.athletept.athletept.user.mapper.UserMapper;
import com.athletept.athletept.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository, UserMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserDto user) {
        if (user.getPassword() == null || user.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password is required");
        }

        UserEntity entity = mapper.toEntity(user);     // password not set by mapper (ignored)
        entity.setPassword(passwordEncoder.encode(user.getPassword())); // set hashed pw

        repository.save(entity);
    }

    public List<UserDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public UserDto getById(String uuid) {
        return repository.findById(uuid)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + uuid));
    }
}

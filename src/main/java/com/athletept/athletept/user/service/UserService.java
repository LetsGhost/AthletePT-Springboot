package com.athletept.athletept.user.service;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.entity.UserEntity;
import com.athletept.athletept.user.mapper.UserMapper;
import com.athletept.athletept.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void createUser(UserDto user) {
        UserEntity userEntity = mapper.toEntity(user);
        //mapper.toDto(repository.save(userEntity));

        System.out.println("Created");
    }
}

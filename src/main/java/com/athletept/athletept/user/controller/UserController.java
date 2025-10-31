package com.athletept.athletept.user.controller;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.mapper.UserMapper;
import com.athletept.athletept.user.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody UserDto user) {
        service.createUser(user);
        return ResponseEntity.ok(200);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDto> getById(@PathVariable String uuid) {
        return ResponseEntity.ok(service.getById(uuid));
    }
}

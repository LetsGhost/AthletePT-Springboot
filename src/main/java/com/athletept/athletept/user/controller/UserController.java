package com.athletept.athletept.user.controller;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

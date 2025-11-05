package com.athletept.athletept.user.controller;

import com.athletept.athletept.user.dto.UserDto;
import com.athletept.athletept.user.mapper.UserMapper;
import com.athletept.athletept.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@Tag(name = "User Controller")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Dieser Endpunkt ist zum erstellen von Admin/User Object in der DB.")
    public ResponseEntity<Integer> createUser(@RequestBody UserDto user) {
        service.createUser(user);
        return ResponseEntity.ok(200);
    }

    @GetMapping
    @Operation(summary = "Dieser Endpunkt gibt alle User/Admin aus der Datenbank zurück")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{uuid}")
    @Operation(summary = "Dieser Endpunkt gibt einen bestimmten User/Admin anhand seiner uuid zurück.")
    public ResponseEntity<UserDto> getById(@PathVariable String uuid) {
        return ResponseEntity.ok(service.getById(uuid));
    }
}

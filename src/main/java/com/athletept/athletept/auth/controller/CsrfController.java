package com.athletept.athletept.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class CsrfController {

    // add inside AuthController or separate CsrfController
    @GetMapping("/csrf")
    public ResponseEntity<?> csrf(org.springframework.security.web.csrf.CsrfToken token) {
        return ResponseEntity.ok(
                java.util.Map.of("headerName", token.getHeaderName(), "token", token.getToken())
        );
    }

}

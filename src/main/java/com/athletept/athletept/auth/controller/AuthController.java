// src/main/java/com/athletept/athletept/auth/AuthController.java
package com.athletept.athletept.auth.controller;

import com.athletept.athletept.auth.Dto.AuthRequest;
import com.athletept.athletept.auth.Dto.AuthResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authManager;

    public AuthController(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest body, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(body.email(), body.password());

        try {
            Authentication auth = authManager.authenticate(token);

            // store in security context + create session
            SecurityContextHolder.getContext().setAuthentication(auth);
            request.getSession(true); // creates JSESSIONID if missing

            return ResponseEntity.ok(new AuthResponse("ok", body.email()));
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(401).body(new AuthResponse("invalid_credentials", null));
        }
    }

    @GetMapping("/me")
    public ResponseEntity<?> me(@AuthenticationPrincipal User principal) {
        if (principal == null) {
            return ResponseEntity.status(401).body(new AuthResponse("unauthenticated", null));
        }
        return ResponseEntity.ok(new AuthResponse("ok", principal.getUsername()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        if (request.getSession(false) != null) {
            request.getSession(false).invalidate();
        }
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok(new AuthResponse("logged_out", null));
    }
}

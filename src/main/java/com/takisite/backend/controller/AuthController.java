package com.takisite.backend.controller;

import com.takisite.backend.model.User;
import com.takisite.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // CORS çözümü
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.emailExists(user.getEmail())) {
            return ResponseEntity.badRequest().body("Bu e-posta zaten kayıtlı.");
        }
        User savedUser = userService.register(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User requestUser) {
        return userService.findByEmail(requestUser.getEmail())
                .filter(u -> u.getPassword().equals(requestUser.getPassword()))
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).body("E-posta veya şifre hatalı"));
    }

}

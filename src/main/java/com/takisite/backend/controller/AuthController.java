package com.takisite.backend.controller;

import com.takisite.backend.model.User;
import com.takisite.backend.security.JwtUtil;
import com.takisite.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://takisite-sevval-saglam.vercel.app"
})
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.emailExists(user.getEmail())) {
            return ResponseEntity.badRequest().body("Bu e-posta zaten kayıtlı.");
        }
        User savedUser = userService.register(user);

        String token = jwtUtil.generateToken(savedUser.getEmail());

        Map<String, Object> response = new HashMap<>();
        response.put("user", savedUser);
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User requestUser) {
        return userService.findByEmail(requestUser.getEmail())
                .filter(u -> u.getPassword().equals(requestUser.getPassword()))
                .map(u -> {
                    String token = jwtUtil.generateToken(u.getEmail());
                    Map<String, Object> response = new HashMap<>();
                    response.put("user", u);
                    response.put("token", token);
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Map<String, Object> errorResponse = new HashMap<>();
                    errorResponse.put("error", "E-posta veya şifre hatalı");
                    return ResponseEntity.status(401).body(errorResponse);
                });
    }

}

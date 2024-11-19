package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.backend.service.JwtTokenProvider;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    // 로그인 API
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println("로그인 시도: username=" + user.getUsername() + ", password=" + user.getPassword());

        String token = userService.authenticate(user.getUsername(), user.getPassword());

        if (token != null) {
            System.out.println("로그인 성공: " + user.getUsername());
            return "Bearer " + token; // JWT 토큰 반환
        } else {
            System.out.println("로그인 실패: Invalid username or password");
            return "Invalid username or password"; // 실패 메시지
        }
    }


}

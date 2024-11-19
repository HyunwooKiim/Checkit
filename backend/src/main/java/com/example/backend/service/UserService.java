package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {


    //여기는 회원가입
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists.";
        }

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // 암호화된 비밀번호로 저장
        userRepository.save(user);
        return "User registered successfully.";
    }


    //여기는 로그인
    public String authenticate(String username, String password) {
        System.out.println("로그인 요청: username=" + username + ", password=" + password);

        User user = userRepository.findByUsername(username);
        if (user != null) {
            System.out.println("사용자 발견: " + user.getUsername());
            if (passwordEncoder.matches(password, user.getPassword())) {
                System.out.println("비밀번호 일치!");
                return jwtTokenProvider.createToken(username); // 비밀번호 일치 시 JWT 토큰 반환
            } else {
                System.out.println("비밀번호 불일치");
            }
        } else {
            System.out.println("사용자 없음");
        }

        return null; // 로그인 실패
    }

}
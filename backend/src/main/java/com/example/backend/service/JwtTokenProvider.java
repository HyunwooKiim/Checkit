package com.example.backend.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey; // 비밀키를 application.properties에서 설정

    private static final long TOKEN_VALIDITY = 1000L * 60 * 60; // 1시간 (밀리초 단위)

    // Base64로 디코딩된 Key 가져오기
    private Key getSigningKey(String secretKey) {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // JWT 토큰 생성
    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + TOKEN_VALIDITY);

        return Jwts.builder()
                .setSubject(username) // 사용자명 (또는 ID 등)
                .setIssuedAt(now) // 발행 시간
                .setExpiration(validity) // 만료 시간
                .signWith(getSigningKey(secretKey), SignatureAlgorithm.HS256) // 서명 키 및 알고리즘
                .compact();
    }

    // JWT 토큰에서 사용자 정보(username) 추출
    public String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

    // JWT 토큰에서 만료 시간 추출
    public Date getExpirationDateFromToken(String token) {
        return getClaimsFromToken(token).getExpiration();
    }

    // JWT 토큰의 클레임을 가져오는 메서드
    private Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey(secretKey)) // 서명 키 설정
                .build()
                .parseClaimsJws(token) // JWT 파싱
                .getBody(); // Claims 반환
    }

    // JWT 토큰 유효성 검증
    public boolean validateToken(String token) {
        try {
            // 만료 시간 검증
            return !getExpirationDateFromToken(token).before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}

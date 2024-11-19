package com.example.backend.repository;

import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // 사용자 이름이 존재하는지 확인
    boolean existsByUsername(String username);

    // 사용자 이름으로 사용자 찾기
    User findByUsername(String username);

}
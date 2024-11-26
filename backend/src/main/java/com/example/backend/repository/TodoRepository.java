package com.example.backend.repository;

import com.example.backend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // 특정 userId와 order로 Todo 조회
    @Query("SELECT MAX(t.order) FROM Todo t WHERE t.userId = :userId")
    Optional<Integer> findMaxOrderByUserId(Long userId);
    Optional<Todo> findByIdAndUserId(Long id, Long userId);

    @Query("SELECT t FROM Todo t WHERE t.order > :order AND t.userId = :userId")
    List<Todo> findByOrderGreaterThanAndUserId(Integer order, Long userId);

    // 특정 order보다 큰 Todo 조회 (userId 없이)
    @Query("SELECT t FROM Todo t WHERE t.order = :order AND t.userId = :userId")
    Optional<Todo> findByOrderAndUserId(Integer order, Long userId);

    List<Todo> findAllByUserIdOrderByOrderAsc(Long userId);



}
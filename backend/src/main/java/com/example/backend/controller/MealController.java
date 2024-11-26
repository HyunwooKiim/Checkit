package com.example.backend.controller;

import com.example.backend.service.MealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meal") // "/api/meal"로 요청을 받음
public class MealController {

    private final MealService mealService; // MealService 사용

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public ResponseEntity<String> getMeal(@RequestParam String date) {
        // MealService에서 급식 데이터를 가져옴
        String mealData = mealService.getMeal(date);
        return ResponseEntity.ok(mealData);
    }
}
package com.example.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MealService {

    private final RestTemplate restTemplate;

    @Value("${NEIS_API_URL}")
    private String baseUrl;

    @Value("${NEIS_API_KEY}")
    private String apiKey;

    public MealService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMeal(String date) {
        // 부산소프트웨어마이스터고등학교의 교육청 코드 및 학교 코드
        String officeCode = "C10"; // 부산광역시교육청
        String schoolCode = "7430310"; // 부산소프트웨어마이스터고등학교

        // NEIS API URL 생성
        String url = String.format("%s?KEY=%s&Type=json&ATPT_OFCDC_SC_CODE=%s&SD_SCHUL_CODE=%s&MLSV_YMD=%s",
                baseUrl, apiKey, officeCode, schoolCode, date);

        // API 요청 및 결과 반환
        return restTemplate.getForObject(url, String.class);
    }
}
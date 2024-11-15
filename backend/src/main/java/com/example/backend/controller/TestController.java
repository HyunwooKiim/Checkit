package com.example.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin(origins = "http://localhost:5173") // Vite 애플리케이션의 URL
public class TestController {

    @GetMapping("/api/test")
    public String test() {
        return "Hello from the backend!";
    }

    @GetMapping(value = "/", produces = "text/html")
    @ResponseBody
    public Resource index() throws Exception {
        // 이 메서드는 루트 경로로 접근 시 index.html 파일을 반환합니다.
        // index.html 파일은 React 애플리케이션의 시작점입니다.
        // React 애플리케이션은 이 HTML 파일을 로드하고, 필요한 경우 이 컨트롤러의 다른 엔드포인트를 호출합니다.
        // 예를 들어, React 애플리케이션은 '/api/test' 엔드포인트를 호출하여 "Hello from the backend!" 문자열을 가져올 수 있습니다.
        return new ClassPathResource("static/index.html"); // index.html 파일의 경로
    }
}
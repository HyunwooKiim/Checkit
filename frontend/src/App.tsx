import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import LoadingScreen from "./components/LoadingScreen";
import LoginPage from "./pages/LoginPage";
import Login from "../test/Login"
import HomePage from "./pages/HomePage";
import SignUpPage from "./pages/SignUpPage";
import Layout from "./components/Layout";
import "./styles/App.css";

function App() {
  const [isLoading, setIsLoading] = useState(true); // 로딩 상태
  const [isLoggedIn, setIsLoggedIn] = useState(false); // 로그인 상태

  useEffect(() => {
    // 비동기 인증 확인 (예: API 호출)
    const checkAuth = async () => {
      try {
        const userToken = localStorage.getItem("userToken"); // 사용자 토큰 확인
        // 실제 API 요청이 필요하다면 여기에 추가
        // 예시:
        // const response = await api.verifyToken(userToken);
        // setIsLoggedIn(response.isValid);
        setIsLoggedIn(!!userToken); // 토큰 유무로 로그인 상태 설정
      } catch (error) {
        console.error("인증 확인 중 오류 발생:", error);
        setIsLoggedIn(false);
      } finally {
        setIsLoading(false); // 로딩 종료
      }
    };

    checkAuth();
  }, []);
  if (isLoading) {
    return <LoadingScreen />;
  }

  return (
    <div className="wrap">
    <Router future={{ v7_startTransition: true, v7_relativeSplatPath: true }}>
      <Routes>
        <Route path="/" element={isLoggedIn ? <HomePage /> : <Navigate to="/login" />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignUpPage />} />
      </Routes>
    </Router>
    </div>

  );
};

export default App;
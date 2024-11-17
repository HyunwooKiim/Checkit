import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import LoadingScreen from "./pages/LoadingScreen";
import LoginPage from "./pages/LoginPage";
import HomePage from "./pages/HomePage";
import SignUpPage from "./pages/SignUpPage";
import "./App.css"
import Layout from "./components/layout/Layout";

const App: React.FC = () => {
  const [isLoading, setIsLoading] = useState(true); // 로딩 상태
  const [isLoggedIn, setIsLoggedIn] = useState(false); // 로그인 상태

  useEffect(() => {
    // 로딩 화면을 2초간 보여주고, 로그인 상태를 확인
    const timer = setTimeout(() => {
      const userToken = localStorage.getItem("userToken"); // 사용자 토큰 확인
      setIsLoggedIn(!!userToken); // 토큰 유무로 로그인 상태 설정
      setIsLoading(false); // 로딩 종료
    }, 2000);

    return () => clearTimeout(timer); // 타이머 정리
  }, []);

  // 로딩 중에는 로딩 화면만 렌더링
  if (isLoading) {
    return <LoadingScreen message="Loading, please wait..." />;
  }

  return (
      <Router>
        <Layout>
          <Routes>
            {/* 로그인 상태에 따라 홈 또는 로그인 페이지로 이동 */}
            <Route
              path="/"
              element={isLoggedIn ? <HomePage /> : <Navigate to="/login" />}
            />
            <Route path="/login" element={<LoginPage />} />
            <Route path="/signup" element={<SignUpPage />} />
          </Routes>
        </Layout>
      </Router>
  );
};

export default App;
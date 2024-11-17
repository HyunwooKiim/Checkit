import React, { useState } from "react";
import style from "./SignUpPage.module.css";

const Login: React.FC = () => {
  const [username, setUsername] = useState<string>("");
  const [password, setPassword] = useState<string>("");

  const handleLogin = (e: React.FormEvent) => {
    e.preventDefault();
    console.log("Logging in with:", { username, password });
    // 여기에 API 요청 코드를 추가할 수 있습니다.
  };

  return (
    <div className={style["login-container"]}>
      <img src="/colorLogo.svg" alt="logo" />
      <h2>Log in</h2>
      <form onSubmit={handleLogin} className={style["login-form"]}>
        <input
          type="text"
          placeholder="username123"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Thisismypassword123$$"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <br />
        <a href="#" className="forgot-password">비밀번호를 잊어버리셨나요?</a>
        <br />
        <button type="submit">Sign Up</button>
      </form>
      <p className="signup-text">
        계정이 없다면? <a href="/login">로그인 하기</a>
      </p>
    </div>
  );
};

export default Login;
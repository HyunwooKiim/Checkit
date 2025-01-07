import React, { useState } from "react";
import styles from "./LoginPage.module.css"; // CSS 모듈로 가져오기

const Login: React.FC = () => {
  const [username, setUsername] = useState<string>("");
  const [password, setPassword] = useState<string>("");

  const handleLogin = (e: React.FormEvent) => {
    e.preventDefault();
    console.log("Logging in with:", { username, password });
    // 여기에 API 요청 코드를 추가할 수 있습니다.
  };

  return (
    <>
    <div className={styles["login-container"]}>
      <img src="/colorLogo.svg" alt="logo" className={styles["logo"]} />
      <h2>Log in</h2>
      <form onSubmit={handleLogin} className={styles["login-form"]}>
        <input
          type="text"
          placeholder="username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <span><a href="#" className={styles["forgot-password"]}>비밀번호를 잊어버리셨나요?</a></span>
        <button type="submit">Login</button>
      </form>
      <p className={styles["signup-text"]}>
        계정이 없다면? <a href="/signup">회원가입 하기</a>
      </p>
    </div>
    </>
  );
};

export default Login;
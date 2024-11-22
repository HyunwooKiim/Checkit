import React, { useState } from "react";
import styles from "./SignUpPage.module.css"; // CSS 모듈로 가져오기

const SignUp: React.FC = () => {
  const [username, setUsername] = useState<string>("");
  const [password, setPassword] = useState<string>("");
  const [confirmPassword, setConfirmPassword] = useState<string>("");

  const handleSignUp = (e: React.FormEvent) => {
    e.preventDefault();
    if (password !== confirmPassword) {
      console.log("Passwords do not match");
      return;
    }
    console.log("Signing up with:", { username, password });
    // 여기에 API 요청 코드를 추가할 수 있습니다.
  };

  return (
    <div className={styles["signup-container"]}>
      <img src="/colorLogo.svg" alt="logo" className={styles["logo"]} />
      <h2>Sign Up</h2>
      <form onSubmit={handleSignUp} className={styles["signup-form"]}>
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
        <input
          type="password"
          placeholder="Confirm Password"
          value={confirmPassword}
          onChange={(e) => setConfirmPassword(e.target.value)}
        />
        <button type="submit">Sign Up</button>
      </form>
      <p className={styles["login-text"]}>
        이미 계정이 있으신가요? <a href="/login">로그인 하기</a>
      </p>
    </div>
  );
};

export default SignUp;
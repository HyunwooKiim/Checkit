import React from "react";
import styles from "./LoadingScreen.module.css"; // CSS 모듈로 가져오기

interface LoadingScreenProps {
  message?: string;
}

const LoadingScreen: React.FC<LoadingScreenProps> = ({ message }) => {
  return (
    <div className={styles["loading-container"]}>
      <div className={styles["mobile-wrapper"]}>
        <img src="/logo.svg" alt="logo" className={styles["logo"]} />
        {message && <p className={styles["loading-message"]}>{message}</p>}
      </div>
    </div>
  );
};

export default LoadingScreen;
// src/components/LoadingScreen.tsx
import React from "react";
import style from "./LoadingScreen.module.css";

interface LoadingScreenProps {
  message?: string;
}

const LoadingScreen: React.FC<LoadingScreenProps> = ({ message }) => {
  return (
    <div className={style["loading-container"]}>
      <div className={style["mobile-wrapper"]}>
        <img src="/logo.svg" alt="logo" className={style["logo"]} />
        {message && <p className={style["loading-message"]}>{message}</p>}
      </div>
    </div>
  );
};

export default LoadingScreen;
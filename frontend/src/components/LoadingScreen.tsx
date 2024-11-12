// src/components/LoadingScreen.tsx
import React from "react";
import "../LoadingScreen.css";
interface LoadingScreenProps {
  message?: string;
}

const LoadingScreen: React.FC<LoadingScreenProps> = ({ message }) => {
  return (
    <div className="loading-container">
      <img src="/Checkit.svg" alt="Logo" className="logo" />
    </div>
  );
};

export default LoadingScreen;

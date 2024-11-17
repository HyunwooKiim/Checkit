import React from "react";
import styles from "./HomePage.module.css";

const HomePage: React.FC = () => {
  return (
    <div className={styles["home-container"]}>
      <h1>홈 페이지</h1>
      <p>여기에 메인 콘텐츠가 표시됩니다.</p>
    </div>
  );
};

export default HomePage;
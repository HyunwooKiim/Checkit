import styles from "./LoadingScreen.module.css"; // CSS 모듈로 가져오기

function LoadingScreen() {
  return (
    <div className={styles["loading-container"]}>
      <div className={styles["mobile-wrapper"]}>
        <img src="/logo.svg" alt="logo" className={styles["logo"]} />
      </div>
    </div>
  );
};

export default LoadingScreen;
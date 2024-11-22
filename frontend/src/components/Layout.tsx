import React from "react";
import styles from "./Layout.module.css";

const Layout: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  return (
    <div className={styles["app-container"]}>
      <div className={styles["mobile-wrapper"]}>{children}</div>
    </div>
  );
};

export default Layout;
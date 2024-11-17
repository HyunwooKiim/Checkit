import React from "react";
import "../../App.css";

const Layout: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  return (
    <div className="app-container">
      <div className="mobile-wrapper">{children}</div>
    </div>
  );
};

export default Layout;
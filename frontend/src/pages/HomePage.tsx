// HomePage.tsx
import React from "react";
import GridLayout from "react-grid-layout";
import Widget from "../components/Widget";
import styles from "./HomePage.module.css";
import "react-grid-layout/css/styles.css";
import "react-resizable/css/styles.css";
import Footer from "../components/Footer";
import Header from "../components/Header";

const HomePage: React.FC = () => {
  const layout = [
    { i: "weather", x: 0, y: 0, w: 1, h: 1 },
    { i: "meals", x: 1, y: 0, w: 1, h: 1 },
    { i: "checklistProgress", x: 2, y: 0, w: 1, h: 1 },
    { i: "contactDorm", x: 3, y: 0, w: 1, h: 1 },
    // 추가 위젯 레이아웃 설정
  ];

  return (
    <>
      <Header />
      <div className={styles["home-container"]}>
        <GridLayout
          className="layout"
          layout={layout}
          cols={4}
          rowHeight={100}
          width={400}
        >
          <div key="weather">
            <Widget type="weather" />
          </div>
          <div key="meals">
            <Widget type="meals" />
          </div>
          <div key="checklistProgress">
            <Widget type="checklistProgress" />
          </div>
          <div key="contactDorm">
            <Widget type="contactDorm" />
          </div>
          {/* 추가 위젯 삽입 */}
        </GridLayout>
      </div>
      <Footer />
    </>
  );
};

export default HomePage;
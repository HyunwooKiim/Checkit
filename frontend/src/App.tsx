// src/App.tsx
import React, { useState, useEffect } from "react";
import LoadingScreen from "./components/LoadingScreen";

const App: React.FC = () => {
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    // 예시로 2초 후에 로딩이 끝난다고 가정합니다.
    const timer = setTimeout(() => {
      setIsLoading(false);
    }, 2000);

    return () => clearTimeout(timer);
  }, []);

  return (
    <>
      {isLoading ? (
        <LoadingScreen />
      ) : (
        <div>
          <h1>메인 콘텐츠</h1>
          <p>여기에 메인 페이지의 내용이 표시됩니다.</p>
        </div>
      )}
    </>
  );
};

export default App;

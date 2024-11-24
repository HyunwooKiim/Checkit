// Widget.tsx
import React from "react";

interface WidgetProps {
  type: string;
}

const Widget: React.FC<WidgetProps> = ({ type }) => {
  switch (type) {
    case "weather":
      return <div>날씨보기</div>;
    case "meals":
      return <div>급식보기</div>;
    case "checklistProgress":
      return <div>체크리스트 수행률</div>;
    case "contactDorm":
      return <div>기숙사에 연락하기</div>;
    case "checklist":
      return <div>체크리스트</div>;
    case "timeToDorm":
      return <div>기숙사 입실까지 남은 시간</div>;
    default:
      return <div>위젯</div>;
  }
};

export default Widget;
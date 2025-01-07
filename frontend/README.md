/src
├── /assets         # 정적 파일 (이미지, 폰트, CSS 등)
│   ├── /images
│   ├── /fonts
│   └── /styles     # 전역 스타일 (e.g., tailwind, global.css)
│       ├── variables.scss
│       └── global.css
├── /components     # 재사용 가능한 컴포넌트
│   ├── /common     # 공통 컴포넌트 (Button, Modal 등)
│   ├── /layout     # 레이아웃 관련 컴포넌트 (Header, Footer 등)
│   └── /features   # 기능별 컴포넌트
├── /hooks          # 사용자 정의 React Hooks
│   └── useAuth.ts
├── /pages          # 페이지 단위 컴포넌트
│   ├── Home.tsx
│   ├── About.tsx
│   └── NotFound.tsx
├── /routes         # 라우팅 관련 코드
│   └── index.tsx
├── /services       # API 호출 및 서비스 로직
│   ├── /api        # API 요청 함수
│   └── /types      # API 응답/요청 타입 정의
├── /store          # 상태 관리 (e.g., Redux, Zustand)
│   └── index.ts
├── /utils          # 공통 유틸 함수 및 헬퍼
│   └── formatDate.ts
├── App.tsx         # 메인 앱 컴포넌트
├── main.tsx        # 진입 파일 (ReactDOM.render or createRoot)
└── vite-env.d.ts   # Vite 관련 타입 정의
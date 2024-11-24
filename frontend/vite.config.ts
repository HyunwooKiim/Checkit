import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: '0.0.0.0', // 네트워크에서 접근 가능하게 설정
    port: 3000,      // 필요한 포트 번호 설정 (기본값: 5173)
  },
})

import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./styles/index.css";
import App from "./App";

const container = document.querySelector("#root");
const root = createRoot(container!);

root.render(
  <StrictMode>
    <App />
  </StrictMode>
);
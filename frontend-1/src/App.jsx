import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import { Dashboard } from "./pages/Dashboard";
import { ProductList } from "./components/ProductList";
import { NavBar } from "./components/Navbar";
import { Home } from "./pages/Home";
import { Login } from "./pages/Login";
import { SaleForm } from "./pages/SaleForm";
import { VentasList } from "./components/VentasList";

export const App = () => {
    const isLoggedIn = true; // 👉 Aquí debería ir el control real con JWT o contexto

  return (
      <Router>
      <NavBar />
      <div className="pt-5 mt-5 px-4"> {/* Añadido padding top para compensar navbar */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          {isLoggedIn ? (
            <>
              <Route path="/dashboard" element={<Dashboard />} />
              <Route path="/productos" element={<ProductList />} />
              <Route path="/ventas" element={<VentasList />} />
            </>
          ) : (
            <Route path="*" element={<Navigate to="/login" />} />
          )}
        </Routes>
      </div>
    </Router>
  );
}
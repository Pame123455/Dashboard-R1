import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import { DashboardCliente } from "./pages/Cliente/DashboardCliente";
import { NavBar } from "./components/Navbar";
import { Home } from "./pages/Home";
import { Login } from "./pages/Login";

import ProtectedRoute from "./Route/ProtectedRoute";

export const App = () => {
 const storedUser = localStorage.getItem("user");
  const user = storedUser ? JSON.parse(storedUser) : null;

  
if (!user) {
  return <Navigate to="/login" />;
}
  console.log("USER STORAGE:", user);

  return (
    <Router>
      <NavBar />

      <div className="pt-5 mt-5 px-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />

          {/* ADMIN */}
          {user?.role === "ADMIN" && (
            <>
              <Route path="/admin/dashboard" element={<DashboardAdmin />} />
              <Route path="/productos" element={<ProductList />} />
              <Route path="/ventas" element={<VentasList />} />
            </>
          )}

          {/* EMPLEADO */}
          {user?.role === "EMPLEADO" && (
            <Route
              path="/empleado/dashboard"
              element={<DashboardEmpleado />}
            />
          )}

          {/* CLIENTE */}
          {user?.role === "CLIENTE" && (
            <Route
              path="/cliente/dashboard"
              element={<DashboardCliente />}
            />
          )}

          

          {/* Fallback */}
          <Route path="*" element={<Navigate to="/login" />} />
        </Routes>
      </div>
    </Router>
  );
}
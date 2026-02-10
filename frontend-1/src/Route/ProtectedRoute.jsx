import { Navigate } from "react-router-dom";

const ProtectedRoute = ({ children, allowedRoles }) => {
  const user = JSON.parse(localStorage.getItem("user"));

  if (!user) return <Navigate to="/login" />;
  if (!allowedRoles.includes(user.rol)) return <Navigate to="/login" />;

  return children;
};

export default ProtectedRoute;

import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

export const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        'http://localhost:8080/api/auth/login',
        {
          email,
          password,
        },
        
      );

      // 👉 AQUÍ está la clave
      const user = response.data;
      console.log("USER LOGIN:", response.data);

      // guardar usuario completo (con rol)
      localStorage.setItem('user', JSON.stringify(user));

      // redirigir según rol
      if (user.role === 'ADMIN') {
        window.location.href = '/admin/dashboard';
      } else if (user.role === 'TRABAJADOR') {
        window.location.href = '/empleado/dashboard';
      } else if (user.role === 'CLIENTE') {
        window.location.href = '/cliente/dashboard';
      }
    } catch (error) {
      console.error(error);
      alert('Login fallido. Verifica tus datos.');
    }
  };

  return (
    
    <div className="login-form">
      <h2>Iniciar sesión</h2>
      <form onSubmit={handleLogin}>
        <input
          id="email"
          name="email"
          type="email"
          placeholder="Correo electrónico"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />

        <input
          name="password"
          type="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />

        <button type="submit">Ingresar</button>
      </form>
    </div>
  );
};

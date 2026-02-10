import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

export const DashboardCliente = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    axios
      .get('http://localhost:8080/api/dashboard')
      .then((res) => setData(res.data))
      .catch((err) => console.error('Error al obtener dashboard:', err));
  }, []);

  if (!data) return <p>Cargando datos...</p>;

  return (
    <div className="container mt-5 pt-5 text-start">
      <h2 className="mb-4">📊 Panel de Control</h2>
      <p className="lead">
        👋 Bienvenida, emprendedora. Aquí tienes un resumen de tu negocio.
      </p>

      {/* Tarjetas informativas */}
      <div className="row">
        {/* Productos */}
        <div className="col-md-4">
          <div className="card bg-light shadow-sm mb-3 rounded">
            <div className="card-header">📦 Productos</div>
            <div className="card-body">
              <h5 className="card-title">Total: {data.totalProductos}</h5>
              <Link to="/productos" className="btn btn-outline-primary w-100">
                Ver productos
              </Link>
            </div>
          </div>
        </div>

        {/* Stock */}
        <div className="col-md-4">
          <div className="card bg-light shadow-sm mb-3 rounded">
            <div className="card-header">📊 Stock</div>
            <div className="card-body">
              <h5 className="card-title">Total: {data.totalStock}</h5>
              <Link to="/productos" className="btn btn-outline-primary w-100">
                Ver stock
              </Link>
            </div>
          </div>
        </div>

        {/* Ventas */}
        <div className="col-md-4">
  <div className="card bg-yellow-100 shadow-sm rounded text-center p-3">
    <h5>🛍️ Ventas</h5>
    <div className="d-flex justify-content-between align-items-center mt-3">
      <div>
        <p className="mb-1"><strong>Cantidad de productos vendidos:</strong> {data.totalVentasProductos}</p>
        <p className="mb-1"><strong>Cantidad de Packs vendidos:</strong> {data.totalVentasPacks}</p>
      </div>
      <div className="bg-yellow-200 rounded-circle p-3 shadow">
        <h4 className="m-0"><strong>Total ventas: </strong>{data.totalVentas}</h4>
      </div>
    </div>
    <Link to="/ventas" className="btn btn-outline-success w-100 mt-3">
      Ver ventas
    </Link>
  </div>
</div>
      </div>

      <div className="col-md-4">
        <div className="card bg-light shadow-sm mb-3 rounded">
          <div className="card-header">📊 Canales</div>
          <div className="card-body">
            <h5 className="card-title">Total: {data.totalCanales}</h5>
            <Link to="/productos" className="btn btn-outline-primary w-100">
              Ver Canales
            </Link>
          </div>
        </div>
      </div>
{/*}
      <h4 className="mt-5">📝 Ventas recientes</h4>
      {ventas.length === 0 ? (
        <p>No hay ventas registradas aún.</p>
      ) : (
        <table className="table table-striped mt-3">
          <thead>
            <tr>
              <th>#</th>
              <th>Producto</th>
              <th>Cantidad</th>
              <th>Fecha</th>
            </tr>
          </thead>
          <tbody>
            {ventas.map((v, i) => (
              <tr key={i}>
                <td>{i + 1}</td>
                <td>{v.producto?.nombre || 'Sin producto'}</td>
                <td>{v.cantidad}</td>
                <td>{new Date(v.fechaHoraRegistroVenta).toLocaleString()}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}*/}

      {/* Accesos rápidos */}
      <h4 className="mt-5">⚡ Accesos rápidos</h4>
      <div className="d-flex flex-wrap gap-3 mt-3">
        <Link to="/productos" className="btn btn-dark">
          📦 Gestión de Productos
        </Link>
        <Link to="/ventas" className="btn btn-dark">
          🛍️ Registro de Ventas
        </Link>
        <Link to="/packs" className="btn btn-dark">
          🎁 Packs y Combos
        </Link>
        <Link to="/canales" className="btn btn-dark">
          🚚 Canales de Venta
        </Link>
        <Link to="/proveedores" className="btn btn-dark">
          🏢 Proveedores
        </Link>
        <Link to="/gastos" className="btn btn-dark">
          💸 Finanzas
        </Link>
      </div>
    </div>
  );
};

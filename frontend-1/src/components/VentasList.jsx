import { useEffect, useState } from "react";
import { getTotalVentas } from "../services/VentaService";

export const VentasList = () => {
  const [ventas, setVentas] = useState([]);

  useEffect(() => {
    loadVentas();
  }, []);

  const loadVentas = () => {
    getTotalVentas()
      .then(setVentas)
      .catch(err => console.error("Error al obtener ventas", err));
  };

  const handleDelete = async (id) => {
    if (window.confirm("¿Seguro que quieres eliminar esta venta?")) {
      try {
        await deleteVenta(id);
        loadVentas(); // recargar tabla
      } catch (err) {
        console.error("Error al eliminar venta", err);
      }
    }
  };


  return (
      <div className="mt-4">
      <h2 className="text-2xl font-bold mb-4">🛍️ Lista de Ventas</h2>

      {ventas.length === 0 ? (
        <p>No hay ventas registradas.</p>
      ) : (
        <table className="table-auto border-collapse border border-gray-300 w-full">
          <thead>
            <tr className="bg-gray-200">
              <th className="border border-gray-300 p-2">ID</th>
              <th className="border border-gray-300 p-2">Producto</th>
              <th className="border border-gray-300 p-2">Cantidad</th>
              <th className="border border-gray-300 p-2">Fecha</th>
              <th className="border border-gray-300 p-2">Acciones</th>
            </tr>
          </thead>
          <tbody>
            {ventas.map((v) => (
              <tr key={v.id}>
                <td className="border border-gray-300 p-2">{v.id}</td>
                <td className="border border-gray-300 p-2">
                  {v.producto || "Producto eliminado"}
                </td>
                <td className="border border-gray-300 p-2">{v.cantidad}</td>
                <td className="border border-gray-300 p-2">
                  {new Date(v.fechaHoraRegistroVenta).toLocaleString()}
                </td>
                <td className="border border-gray-300 p-2 space-x-2">
                  <button
                    onClick={() => alert("Editar pronto")}
                    className="bg-blue-500 text-white px-2 py-1 rounded"
                  >
                    Editar
                  </button>
                  <button
                    onClick={() => handleDelete(v.id)}
                    className="bg-red-500 text-white px-2 py-1 rounded"
                  >
                    Eliminar
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
    
  )
      
};

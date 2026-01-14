// components/ProductList.jsx
import { useEffect, useState } from "react";

import { getAllProductos, deleteProducto } from "../services/ProductService";


export const ProductList = ()  =>{
   const [productos, setProductos] = useState([]);
 

 
  useEffect(() => {
    loadProductos();
  }, []);

  const loadProductos = () => {
    getAllProductos().then(setProductos);
  };

  const handleDelete = async (id) => {
    if (window.confirm("¿Seguro que quieres eliminar este producto?")) {
      await deleteProducto(id);
      loadProductos(); // Recargar lista
    }
  };
 

  return (
    <>
    <div className="mt-4">
          <h2 className="text-xl font-bold mb-2">Lista de Productos</h2>
          <table className="table-auto border-collapse border border-gray-300 w-full">
            <thead>
              <tr className="bg-gray-200">
                <th className="border border-gray-300 p-2">ID</th>
                <th className="border border-gray-300 p-2">Nombre</th>
                <th className="border border-gray-300 p-2">Marca</th>
                <th className="border border-gray-300 p-2">Sabor</th>
                <th className="border border-gray-300 p-2">Contenido</th>
                <th className="border border-gray-300 p-2">Unidad</th>
                <th className="border border-gray-300 p-2">Acciones</th>
              </tr>
            </thead>
            <tbody>
              {productos.map((p) => (
                <tr key={p.id}>
                  <td className="border border-gray-300 p-2">{p.id}</td>
                  <td className="border border-gray-300 p-2">{p.nombre}</td>
                  <td className="border border-gray-300 p-2">{p.marca}</td>
                  <td className="border border-gray-300 p-2">{p.sabor}</td>
                  <td className="border border-gray-300 p-2">{p.contenido}</td>
                  <td className="border border-gray-300 p-2">{p.unidad_marca}</td>
                  <td className="border border-gray-300 p-2 space-x-2">
                <button
                  onClick={() => alert("Editar pronto")}
                  className="bg-blue-500 text-white px-2 py-1 rounded"
                >
                  Editar
                </button>
                <button
                  onClick={() => handleDelete(p.id)}
                  className="bg-red-500 text-white px-2 py-1 rounded"
                >
                  Eliminar
                </button>
              </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
    </>
   
        
     
  );
  // const [products, setProducts] = useState([]);

  // useEffect(() => {
  //   getAllProducts().then(setProducts);
  // }, []);

  
  // return (
  //    <div className="p-8 text-black">
  //     <h2 className="text-2xl font-bold mb-4">📦 Lista de Productos</h2>
  //     <table className="w-full text-left border border-white">
  //       <thead>
  //         <tr>
  //           <th>Nombre</th>
  //           <th>Marca</th>
  //           <th>Sabor</th>
  //           <th>Contenido</th>
  //           <th>Unidad</th>
  //         </tr>
  //       </thead>
  //       <tbody>
  //         {products.map((p, i) => (
  //           <tr key={i}>
  //             <td>{p.nombre}</td>
  //             <td>{p.marca}</td>
  //             <td>{p.sabor}</td>
  //             <td>{p.contenido}</td>
  //             <td>{p.unidadMarca}</td>
  //           </tr>
  //         ))}
  //       </tbody>
  //     </table>
  //   </div>
  // );
}

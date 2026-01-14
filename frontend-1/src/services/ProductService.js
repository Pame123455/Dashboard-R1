import axios from 'axios';

const API = "http://localhost:8080/api/productos";


export const getAllProductos = async () => {
  const res = await axios.get(API);
  return res.data;
};

export const deleteProducto = async (id) => {
  await axios.delete(`${API}/${id}`);
};

export const updateProducto = async (id, data) => {
  const res = await axios.put(`${API}/${id}`, data);
  return res.data;
}; 

export const getAllProducts = async () => {
  const res = await axios.get(`${API}/con-stock`);
  return res.data;
};
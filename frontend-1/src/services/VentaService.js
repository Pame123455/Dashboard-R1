import axios from "axios";

const API_VENTAS = "http://localhost:8080/api/ventas";

export const getAllVentas = async () => {
  const res = await axios.get(API_VENTAS);
  return res.data;
};

// Nuevo método para traer todas las ventas
export const getTotalVentas = async () => {
  const res = await axios.get(`${API_VENTAS}/all`);
  return res.data;
};

export const deleteVenta = async (id) => {
  await axios.delete(`${API_VENTAS}/${id}`);
};

export const updateVenta = async (id, data) => {
  const res = await axios.put(`${API_VENTAS}/${id}`, data);
  return res.data;
};



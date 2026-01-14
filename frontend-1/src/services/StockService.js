import axios from 'axios';

const API = "http://localhost:8080/api/stock";

export const getAllStock = async () => {
  const res = await axios.get(API);
  return res.data;
};

export const updateStock = async (id, stockData) => {
  const res = await axios.put(`${API}/${id}`, stockData);
  return res.data;
};
export const SaleForm = () => {
    return (
    <div className="p-8 text-white">
      <h2 className="text-2xl font-bold mb-4">🛒 Registrar Venta</h2>
      <form className="space-y-4">
        <input className="w-full p-2 text-black" placeholder="Producto o Pack ID" />
        <input className="w-full p-2 text-black" placeholder="Cantidad" type="number" />
        <button type="submit" className="bg-green-500 p-2 rounded">Registrar</button>
      </form>
    </div>
  );
}
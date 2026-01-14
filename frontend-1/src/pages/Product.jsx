export const Product = ({ product }) => {
   return (
    <div className="border p-4 rounded shadow-sm bg-white">
      <h2 className="text-lg font-semibold">{product.nombre}</h2>
      <p>{product.descripcion}</p>
      <p className="text-sm text-gray-500">Marca: {product.marca}</p>
      <p className="text-sm text-gray-500">Sabor: {product.sabor}</p>
      <p className="text-sm text-gray-500">
        Contenido: {product.contenido} {product.unidad_marca}
      </p>
    </div>
  );
}
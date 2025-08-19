package ferregestion.view;

import ferregestion.entities.Producto;
import ferregestion.model.DAOImpl.ProductoImpl;

public class PruebaProducto {
    public static void main(String[] args) {
        ProductoImpl dao = new ProductoImpl();

        // === AGREGAR PRODUCTO ===
        //dao.agregarProducto(new Producto("Martillo", "C001", "G001", 19.0, 10000, 15000, 20));

        // === CONSULTAR TODOS ===
        //System.out.println(dao.consultarProductos());

        // === CONSULTAR POR NOMBRE ===
        //System.out.println(dao.consultarPorNombre(new Producto(0, "Martillo", null, 0, 0, 0, 0)));

        // === CONSULTAR POR GRUPO ===
        //System.out.println(dao.consultarPorGrupo(new Producto(0, null, "G001", 0, 0, 0, 0)));

        // === MODIFICAR PRODUCTO (ejemplo: actualizar descripción y precios) ===
        dao.modificarProducto(new Producto(8, "Martillo reforzado", "C001","G001", 19.0, 16000, 22000, 50));
        System.out.println(dao.consultarProductos());

        // === ACTUALIZAR STOCK ===
        //dao.actualizarStock(new Producto(8, "", "", 0, 0, 0, 15));
        //System.out.println(dao.consultarProductos());

        // === CONSULTAR POR ID ===
//        System.out.println(dao.consultarPorId(new Producto(1, null, null, 0, 0, 0, 0)));

        // === ELIMINAR PRODUCTO ===
        //dao.eliminarProducto(new Producto(7, null, null, 0, 0, 0, 0));
        //System.out.println(dao.consultarProductos());
    }
}

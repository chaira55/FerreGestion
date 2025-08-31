package ferregestion.view;

import ferregestion.entities.Producto;
import ferregestion.model.DAOImpl.ProductoImpl;

public class PruebaProducto {
    public static void main(String[] args) {
        ProductoImpl dao = new ProductoImpl();

        dao.eliminarProducto(new Producto(8,"", null, null, 0, 0, 0, 0));


        // === AGREGAR PRODUCTO ===
        // Construcción - Herramientas
        dao.agregarProducto(new Producto("Martillo", "C001", "G001", 19.0, 10000, 15000, 20));
        dao.agregarProducto(new Producto("Taladro", "C001", "G001", 19.0, 200000, 250000, 10));
        dao.agregarProducto(new Producto("Destornillador", "C001", "G001", 19.0, 5000, 8000, 50));

// Construcción - Materiales
        dao.agregarProducto(new Producto("Cemento 50kg", "C001", "G002", 5.0, 20000, 30000, 100));
        dao.agregarProducto(new Producto("Arena m³", "C001", "G002", 5.0, 50000, 70000, 30));

// Pintura
        dao.agregarProducto(new Producto("Pintura Blanca 1gl", "C002", "G003", 19.0, 30000, 45000, 25));
        dao.agregarProducto(new Producto("Rodillo 9''", "C002", "G003", 19.0, 8000, 12000, 40));

// Electricidad
        dao.agregarProducto(new Producto("Cable #12 x metro", "C003", "G004", 19.0, 1000, 2000, 200));
        dao.agregarProducto(new Producto("Interruptor sencillo", "C003", "G004", 19.0, 2000, 3500, 70));

// Fontanería
        dao.agregarProducto(new Producto("Tubo PVC 1''", "C004", "G005", 19.0, 7000, 12000, 60));
        dao.agregarProducto(new Producto("Codo PVC 1''", "C004", "G005", 19.0, 500, 1000, 150));

        // === CONSULTAR TODOS ===
        //System.out.println(dao.consultarProductos());

        // === CONSULTAR POR NOMBRE ===
        //System.out.println(dao.consultarPorNombre(new Producto(0, "Martillo", null, 0, 0, 0, 0)));

        // === CONSULTAR POR GRUPO ===
        //System.out.println(dao.consultarPorGrupo(new Producto(0, null, "G001", 0, 0, 0, 0)));

        // === MODIFICAR PRODUCTO (ejemplo: actualizar descripción y precios) ===
        //dao.modificarProducto(new Producto(8, "Martillo reforzado", "C001","G001", 19.0, 16000, 22000, 50));
        //System.out.println(dao.consultarProductos());

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

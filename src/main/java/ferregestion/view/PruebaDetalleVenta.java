package ferregestion.view;

import ferregestion.entities.DetalleVenta;
import ferregestion.model.DAOImpl.DetalleVentaImpl;

public class PruebaDetalleVenta {
    public static void main(String[] args) {
        DetalleVentaImpl dao = new DetalleVentaImpl();

        // Agregar detalle
        DetalleVenta nuevo = new DetalleVenta(2, 9, "Martillo", 2, 15000.0, 30000.0);
        boolean insertado = dao.agregarDetalleVenta(nuevo);
        System.out.println("Detalle insertado: " + insertado);
/*
        // Consultar todos
        List<DetalleVenta> lista = dao.consultarTodos();
        lista.forEach(System.out::println);

        // Modificar el primero
        if (!lista.isEmpty()) {
            DetalleVenta primero = lista.get(0);
            primero.setCantidad(5);
            primero.setSubtotal(primero.getCantidad() * primero.getPrecio_unitario());
            boolean modificado = dao.modificarDetalleVenta(primero);
            System.out.println("Detalle modificado: " + modificado);
        }

        // Consultar por venta
        DetalleVenta filtro = new DetalleVenta();
        filtro.setId_venta(1);
        List<DetalleVenta> porVenta = dao.consultarPorVenta(filtro);
        porVenta.forEach(c -> System.out.println("Por venta: " + c));

        // Eliminar el último
        if (!lista.isEmpty()) {
            DetalleVenta ultimo = lista.get(lista.size() - 1);
            boolean eliminado = dao.eliminarDetalleVenta(ultimo);
            System.out.println("Detalle eliminado: " + eliminado);
        }
*/    }
}

package ferregestion.view;

import ferregestion.entities.Venta;
import ferregestion.model.DAOImpl.VentaImpl;

import java.time.LocalDate;
import java.util.List;

public class PruebaVenta {
    public static void main(String[] args) {
        VentaImpl ventaDAO = new VentaImpl();

        // 1. Probar agregarVenta
        Venta nuevaVenta = new Venta();
        nuevaVenta.setCedula(123456789);
        nuevaVenta.setFecha(LocalDate.of(2025, 8, 13));
        nuevaVenta.setTotal(150000.0);

        boolean insertada = ventaDAO.agregarVenta(nuevaVenta);
        System.out.println("Venta insertada: " + insertada);

        // 2. Probar consultarVentas
        List<Venta> ventas = ventaDAO.consultarVentas();
        System.out.println("Lista de ventas:");
        for (Venta v : ventas) {
            System.out.println(v);
        }

        // 3. Probar consultarPorCliente
        Venta ventaFiltroCliente = new Venta();
        ventaFiltroCliente.setCedula(123456789);
        List<Venta> ventasCliente = ventaDAO.consultarPorCliente(ventaFiltroCliente);
        System.out.println("Ventas del cliente 123456789:");
        for (Venta v : ventasCliente) {
            System.out.println(v);
        }

        // 4. Probar eliminarVenta
        Venta ventaAEliminar = new Venta();
        ventaAEliminar.setId_venta(3); // ID de la venta que quieras borrar
        boolean eliminada = ventaDAO.eliminarVenta(ventaAEliminar);
        System.out.println("Venta eliminada: " + eliminada);

        // 5. Probar consultarPorFecha
        /*LocalDate fechaBusqueda = LocalDate.of(2025, 8, 13);
        List<Venta> ventasPorFecha = ventaDAO.consultarPorFecha(fechaBusqueda);
        System.out.println("Ventas en la fecha " + fechaBusqueda + ":");
        for (Venta v : ventasPorFecha) {
            System.out.println(v);
        }*/
    }
}

package ferregestion.view;

import ferregestion.entities.Venta;
import ferregestion.model.DAOImpl.VentaImpl;

import java.time.LocalDate;
import java.util.List;

public class PruebaVenta {
    public static void main(String[] args) {
        VentaImpl dao = new VentaImpl();

        // Agregar una venta
        Venta nueva = new Venta(123456789, "Juan Pérez", 4, LocalDate.now(), 250000.0, "contado");
        boolean insertado = dao.agregarVenta(nueva);
        System.out.println("Venta insertada: " + insertado);
/*
        // Consultar todas
        List<Venta> lista = dao.consultarVentas();
        lista.forEach(System.out::println);

        // Modificar la primera
        if (!lista.isEmpty()) {
            Venta primera = lista.get(0);
            primera.setTotal(600000.0);
            primera.setTipo_pago("credito");
            boolean modificado = dao.modificarVenta(primera);
            System.out.println("Venta modificada: " + modificado);
        }

        // Consultar por cliente
        Venta filtroCliente = new Venta();
        filtroCliente.setCedula(123456789);
        List<Venta> porCliente = dao.consultarPorCliente(filtroCliente);
        porCliente.forEach(c -> System.out.println("Por cliente: " + c));

        // Eliminar la última
        if (!lista.isEmpty()) {
            Venta ultima = lista.get(lista.size() - 1);
            boolean eliminado = dao.eliminarVenta(ultima);
            System.out.println("Venta eliminada: " + eliminado);
        }

        // Consultar de nuevo
        lista = dao.consultarVentas();
        lista.forEach(c -> System.out.println("Después de eliminar: " + c));
*/    }
}

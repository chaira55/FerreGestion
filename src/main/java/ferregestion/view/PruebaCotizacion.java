package ferregestion.view;

import ferregestion.entities.Cotizacion;
import ferregestion.model.DAOImpl.CotizacionImpl;

import java.time.LocalDate;
import java.util.List;

public class PruebaCotizacion {
    public static void main(String[] args) {
        CotizacionImpl dao = new CotizacionImpl();
        List<Cotizacion> lista = dao.consultarCotizacion();
/*
        // Agregar cotización
        Cotizacion nueva = new Cotizacion(123456789, "Juan Pérez", LocalDate.now(), 200000.0);
        boolean insertado = dao.agregarCotizacion(nueva);
        System.out.println("Cotización insertada: " + insertado);

        // Consultar todas
        lista.forEach(System.out::println);
*/
        // Modificar cotización (ejemplo: cambiar total y fecha)
        if (!lista.isEmpty()) {
            Cotizacion primera = lista.get(0);
            primera.setTotal(250000.0);
            primera.setFecha(LocalDate.now().plusDays(1));
            boolean modificado = dao.modificarActualizacion(primera);
            System.out.println("Cotización modificada: " + modificado);
        }
        /*
        // Consultar de nuevo para ver cambios
        lista = dao.consultarCotizacion();
        lista.forEach(c -> System.out.println("Después de modificar: " + c));

        // Eliminar cotización
        if (!lista.isEmpty()) {
            Cotizacion ultima = lista.get(lista.size() - 1); // la última de la BD
            boolean eliminado = dao.eliminarCotizacion(ultima.getId_cotizacion());
            System.out.println("Cotización eliminada: " + eliminado);
        }

        // Consultar de nuevo para ver cambios después de eliminar
        lista = dao.consultarCotizacion();
        lista.forEach(c -> System.out.println("Después de eliminar: " + c));

        // Consultar por cliente
        Cotizacion filtroCliente = new Cotizacion();
        filtroCliente.setCedula(123456789);
        List<Cotizacion> porCliente = dao.consultarPorCliente(filtroCliente);
        porCliente.forEach(c -> System.out.println("Por cliente: " + c));

        // Consultar por fecha
        Cotizacion filtroFecha = new Cotizacion();
        filtroFecha.setFecha(LocalDate.now());
        List<Cotizacion> porFecha = dao.consultarPorFecha(filtroFecha);
        porFecha.forEach(c -> System.out.println("Por fecha: " + c));
  */  }
}

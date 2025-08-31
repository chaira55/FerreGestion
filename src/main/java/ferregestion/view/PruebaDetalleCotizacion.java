package ferregestion.view;

import ferregestion.entities.DetalleCotizacion;
import ferregestion.model.DAOImpl.DetalleCotizacionImpl;

import java.util.List;

public class PruebaDetalleCotizacion {
    public static void main(String[] args) {
        DetalleCotizacionImpl dao = new DetalleCotizacionImpl();

        // Agregar detalle
        DetalleCotizacion detalle = new DetalleCotizacion(
                4, 10, "Taladro", 1, 200000.0, 200000.0
        );
        boolean insertado = dao.agregarDetalleCotizacion(detalle);
        System.out.println("Detalle insertado: " + insertado);
/*
        // Consultar todos
        List<DetalleCotizacion> lista = dao.consultarDetalleCotizacion();
        lista.forEach(System.out::println);

        // Consultar por ID
        if (!lista.isEmpty()) {
            DetalleCotizacion primero = lista.get(0);
            DetalleCotizacion buscado = dao.consultarPorId(primero);
            System.out.println("Buscado por ID: " + buscado);
        }

        // Eliminar último
        if (!lista.isEmpty()) {
            DetalleCotizacion ultimo = lista.get(lista.size() - 1);
            boolean eliminado = dao.eliminarDetaleCotizacion(ultimo);
            System.out.println("Detalle eliminado: " + eliminado);
        }
 */   }
}

package ferregestion.model.DAO;

import ferregestion.entities.Cotizacion;
import java.util.List;


public interface ICotizacionDAO {
    List<Cotizacion> consultarCotizacion();
    List<Cotizacion> consultarPorCliente(Cotizacion cotizacion);
    List<Cotizacion> consultarPorFecha(Cotizacion cotizacion);
    Cotizacion consultarPorId(int idCotizacion);
    boolean modificarActualizacion(Cotizacion cotizacion);
    boolean eliminarCotizacion(int id_cotizacion);
    boolean agregarCotizacion(Cotizacion cotizacion);
}

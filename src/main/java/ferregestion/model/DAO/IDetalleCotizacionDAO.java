package ferregestion.model.DAO;

import ferregestion.entities.DetalleCotizacion;

import java.util.List;

public interface IDetalleCotizacionDAO {
    List<DetalleCotizacion> consultarDetalleCotizacion();
    boolean agregarDetalleCotizacion(DetalleCotizacion detalleCotizacion);
    boolean eliminarDetaleCotizacion(DetalleCotizacion detalleCotizacion);
    DetalleCotizacion consultarPorId(DetalleCotizacion detalleCotizacion);
}

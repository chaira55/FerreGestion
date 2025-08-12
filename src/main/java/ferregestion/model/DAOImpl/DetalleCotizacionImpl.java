package ferregestion.model.DAOImpl;

import ferregestion.entities.DetalleCotizacion;
import ferregestion.model.DAO.IDetalleCotizacionDAO;

import java.util.List;

public class DetalleCotizacionImpl implements IDetalleCotizacionDAO {
    @Override
    public List<DetalleCotizacion> consultarDetalleCotizacion() {
        return List.of();
    }

    @Override
    public boolean agregarDetalleCotizacion(DetalleCotizacion detalleCotizacion) {
        return false;
    }

    @Override
    public boolean eliminarDetaleCotizacion(DetalleCotizacion detalleCotizacion) {
        return false;
    }

    @Override
    public DetalleCotizacion consultarPorId(DetalleCotizacion detalleCotizacion) {
        return null;
    }
}

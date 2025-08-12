package ferregestion.model.DAOImpl;

import ferregestion.entities.Cotizacion;
import ferregestion.model.DAO.ICotizacionDAO;

import java.util.List;

public class CotizacionImpl implements ICotizacionDAO {
    @Override
    public List<Cotizacion> consultarCotizacion() {
        return List.of();
    }

    @Override
    public List<Cotizacion> consultarPorCliente(Cotizacion cotizacion) {
        return List.of();
    }

    @Override
    public List<Cotizacion> consultarPorFecha(Cotizacion cotizacion) {
        return List.of();
    }

    @Override
    public boolean modificarActualizacion(Cotizacion cotizacion) {
        return false;
    }

    @Override
    public boolean eliminarCotizacion() {
        return false;
    }

    @Override
    public boolean agregrCotizacion(Cotizacion cotizacion) {
        return false;
    }
}

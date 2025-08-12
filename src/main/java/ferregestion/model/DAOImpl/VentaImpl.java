package ferregestion.model.DAOImpl;

import ferregestion.entities.Venta;
import ferregestion.model.DAO.IVentaDAO;

import java.util.List;

public class VentaImpl implements IVentaDAO {
    @Override
    public List<Venta> consultarVentas() {
        return List.of();
    }

    @Override
    public List<Venta> consultarPorCliente(Venta venta) {
        return List.of();
    }

    @Override
    public List<Venta> consultarPorFecha(Venta venta) {
        return List.of();
    }

    @Override
    public boolean eliminarVenta(Venta venta) {
        return false;
    }

    @Override
    public boolean agregarVenta(Venta venta) {
        return false;
    }
}

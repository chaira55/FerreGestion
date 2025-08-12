package ferregestion.model.DAOImpl;

import ferregestion.entities.DetalleVenta;
import ferregestion.model.DAO.IDetalleVentaDAO;

import java.util.List;

public class DetalleVentaImpl implements IDetalleVentaDAO {
    @Override
    public List<DetalleVenta> consultarTodos() {
        return List.of();
    }

    @Override
    public List<DetalleVenta> consultarPorVenta(DetalleVenta detalle) {
        return List.of();
    }

    @Override
    public boolean modificarDetalleVenta(DetalleVenta detalle) {
        return false;
    }

    @Override
    public boolean eliminarDetalleVenta(DetalleVenta detalle) {
        return false;
    }

    @Override
    public boolean agregarDetalleVenta(DetalleVenta detalle) {
        return false;
    }

    @Override
    public DetalleVenta consultarPorCliente(DetalleVenta detalle) {
        return null;
    }
}

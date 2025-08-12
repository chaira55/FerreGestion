package ferregestion.model.DAOImpl;

import ferregestion.entities.Pago;
import ferregestion.model.DAO.IPagoDAO;

import java.util.List;

public class PagoImpl implements IPagoDAO {
    @Override
    public List<Pago> consultarTodos() {
        return List.of();
    }

    @Override
    public List<Pago> consultarCliente(Pago pago) {
        return List.of();
    }

    @Override
    public List<Pago> consultarPorFecha(Pago pago) {
        return List.of();
    }

    @Override
    public boolean agregarPago(Pago pago) {
        return false;
    }

    @Override
    public boolean modificarPago(Pago pago) {
        return false;
    }

    @Override
    public boolean eliminarPago(Pago pago) {
        return false;
    }
}

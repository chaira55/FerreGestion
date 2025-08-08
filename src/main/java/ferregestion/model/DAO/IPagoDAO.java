package ferregestion.model.DAO;

import ferregestion.entities.Pago;

import java.util.List;

public interface IPagoDAO {
    List<Pago> consultarTodos();
    List<Pago> consultarCliente(Pago pago);
    List<Pago> consultarPorFecha(Pago pago);
    boolean agregarPago(Pago pago);
    boolean modificarPago(Pago pago);
    boolean eliminarPago(Pago pago);

}

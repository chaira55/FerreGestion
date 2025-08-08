package ferregestion.model.DAO;

import ferregestion.entities.DetalleVenta;
import java.util.List;

public interface IDetalleVentaDAO {
    List<DetalleVenta> consultarTodos();
    List<DetalleVenta> consultarPorVenta(DetalleVenta detalle);
    boolean modificarDetalleVenta(DetalleVenta detalle);
    boolean eliminarDetalleVenta(DetalleVenta detalle);
    boolean agregarDetalleVenta(DetalleVenta detalle);
    DetalleVenta consultarPorCliente(DetalleVenta detalle);
}

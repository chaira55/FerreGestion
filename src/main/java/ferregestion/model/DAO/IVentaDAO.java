package ferregestion.model.DAO;

import ferregestion.entities.Venta;
import java.util.List;

public interface IVentaDAO {
    List<Venta> consultarVentas();
    List<Venta> consultarPorCliente(Venta venta);
    List<Venta> consultarPorFecha(Venta venta);
    boolean eliminarVenta(Venta venta);
    boolean agregarVenta(Venta venta);
    boolean modificarVenta(Venta venta);
}

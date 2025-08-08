package ferregestion.model.DAO;

import ferregestion.entities.Producto;
import java.util.List;

public interface IProductoDAO {
    List<Producto> consultarProductos();
    List<Producto> consultarPorNombre(Producto producto);
    List<Producto> consultarPorGrupo(Producto producto);
    boolean modificarProducto(Producto producto);
    boolean actualizarStock(Producto producto);
    boolean eliminarProducto(Producto producto);
    boolean agregarProducto(Producto producto);
    boolean consultarPorId(Producto producto);
}

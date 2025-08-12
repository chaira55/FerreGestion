package ferregestion.model.DAOImpl;

import ferregestion.entities.Producto;
import ferregestion.model.DAO.IProductoDAO;

import java.util.List;

public class ProductoImpl implements IProductoDAO {
    @Override
    public List<Producto> consultarProductos() {
        return List.of();
    }

    @Override
    public List<Producto> consultarPorNombre(Producto producto) {
        return List.of();
    }

    @Override
    public List<Producto> consultarPorGrupo(Producto producto) {
        return List.of();
    }

    @Override
    public boolean modificarProducto(Producto producto) {
        return false;
    }

    @Override
    public boolean actualizarStock(Producto producto) {
        return false;
    }

    @Override
    public boolean eliminarProducto(Producto producto) {
        return false;
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        return false;
    }

    @Override
    public boolean consultarPorId(Producto producto) {
        return false;
    }
}

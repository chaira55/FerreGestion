package ferregestion.model.DAOImpl;

import ferregestion.conexion.ConexionBD;
import ferregestion.entities.Producto;
import ferregestion.model.DAO.IProductoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoImpl implements IProductoDAO {

    @Override
    public List<Producto> consultarProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (Connection conn = ConexionBD.getConexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Producto p = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("descripcion"),
                        rs.getString("codigo_clase"),
                        rs.getString("codigo_grupo"),
                        rs.getDouble("iva"),
                        rs.getDouble("precio_compra"),
                        rs.getDouble("precio_venta"),
                        rs.getInt("stock")
                );
                productos.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public List<Producto> consultarPorNombre(Producto producto) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE descripcion LIKE ?";

        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + producto.getDescripcion() + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("descripcion"),
                        rs.getString("codigo_clase"),
                        rs.getString("codigo_grupo"),
                        rs.getDouble("iva"),
                        rs.getDouble("precio_compra"),
                        rs.getDouble("precio_venta"),
                        rs.getInt("stock")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public List<Producto> consultarPorGrupo(Producto producto) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE codigo_grupo = ?";

        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getCodigo_clase());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                productos.add(new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("descripcion"),
                        rs.getString("codigo_clase"),
                        rs.getString("codigo_grupo"),
                        rs.getDouble("iva"),
                        rs.getDouble("precio_compra"),
                        rs.getDouble("precio_venta"),
                        rs.getInt("stock")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public boolean modificarProducto(Producto producto) {
        String sql = "UPDATE producto SET descripcion=?, codigo_clase=?, codigo_grupo=?, iva=?, precio_compra=?, precio_venta=?, stock=? WHERE id_producto=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getDescripcion());
            ps.setString(2, producto.getCodigo_clase());
            ps.setString(3, producto.getCodigo_grupo());
            ps.setDouble(4, producto.getIva());
            ps.setDouble(5, producto.getPrecio_compra());
            ps.setDouble(6, producto.getPrecio_venta());
            ps.setInt(7, producto.getStock());
            ps.setInt(8, producto.getId_producto());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizarStock(Producto producto) {
        String sql = "UPDATE producto SET stock = ? WHERE id_producto = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, producto.getStock());
            ps.setInt(2, producto.getId_producto());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarProducto(Producto producto) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, producto.getId_producto());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean agregarProducto(Producto producto) {
        String sql = "INSERT INTO producto (descripcion, codigo_clase, codigo_grupo, iva, precio_compra, precio_venta, stock) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, producto.getDescripcion());
            ps.setString(2, producto.getCodigo_clase());
            ps.setString(3, producto.getCodigo_grupo());
            ps.setDouble(4, producto.getIva());
            ps.setDouble(5, producto.getPrecio_compra());
            ps.setDouble(6, producto.getPrecio_venta());
            ps.setInt(7, producto.getStock());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean consultarPorId(Producto producto) {
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, producto.getId_producto());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

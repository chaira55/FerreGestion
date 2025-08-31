package ferregestion.model.DAOImpl;

import ferregestion.entities.DetalleVenta;
import ferregestion.model.DAO.IDetalleVentaDAO;
import ferregestion.conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaImpl implements IDetalleVentaDAO {

    @Override
    public List<DetalleVenta> consultarTodos() {
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                DetalleVenta d = new DetalleVenta(
                        rs.getInt("id_detalle_venta"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getDouble("subtotal"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_unitario")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<DetalleVenta> consultarPorVenta(DetalleVenta detalle) {
        List<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_venta WHERE id_venta = ?";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getId_venta());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DetalleVenta d = new DetalleVenta(
                        rs.getInt("id_detalle_venta"),
                        rs.getInt("id_venta"),
                        rs.getInt("id_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getDouble("subtotal"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_unitario")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean modificarDetalleVenta(DetalleVenta detalle) {
        String sql = "UPDATE detalle_venta SET id_venta=?, id_producto=?, descripcion_producto=?, cantidad=?, precio_unitario=?, subtotal=? WHERE id_detalle_venta=?";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getId_venta());
            ps.setInt(2, detalle.getId_producto());
            ps.setString(3, detalle.getDescripcion_producto());
            ps.setInt(4, detalle.getCantidad());
            ps.setDouble(5, detalle.getPrecio_unitario());
            ps.setDouble(6, detalle.getSubtotal());
            ps.setInt(7, detalle.getId_detalle_venta());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminarDetalleVenta(DetalleVenta detalle) {
        String sql = "DELETE FROM detalle_venta WHERE id_detalle_venta = ?";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getId_detalle_venta());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarDetalleVenta(DetalleVenta detalle) {
        String sql = "INSERT INTO detalle_venta (id_venta, id_producto, descripcion_producto, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getId_venta());
            ps.setInt(2, detalle.getId_producto());
            ps.setString(3, detalle.getDescripcion_producto());
            ps.setInt(4, detalle.getCantidad());
            ps.setDouble(5, detalle.getPrecio_unitario());
            ps.setDouble(6, detalle.getSubtotal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

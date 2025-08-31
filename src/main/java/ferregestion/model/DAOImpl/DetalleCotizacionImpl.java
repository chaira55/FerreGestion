package ferregestion.model.DAOImpl;

import ferregestion.entities.DetalleCotizacion;
import ferregestion.model.DAO.IDetalleCotizacionDAO;
import ferregestion.conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetalleCotizacionImpl implements IDetalleCotizacionDAO {

    private DetalleCotizacion mapear(ResultSet rs) throws SQLException {
        return new DetalleCotizacion(
                rs.getInt("id_detalle_cotizacion"),
                rs.getInt("id_cotizacion"),
                rs.getInt("id_producto"),
                rs.getString("descripcion_producto"),
                rs.getInt("cantidad"),
                rs.getDouble("precio_unitario"),
                rs.getDouble("subtotal_producto")
        );
    }

    @Override
    public List<DetalleCotizacion> consultarDetalleCotizacion() {
        List<DetalleCotizacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_cotizacion ORDER BY id_detalle_cotizacion DESC";
        try (Connection conn = ConexionBD.getConexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) lista.add(mapear(rs));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean agregarDetalleCotizacion(DetalleCotizacion d) {
        String sql = "INSERT INTO detalle_cotizacion (id_cotizacion, id_producto, descripcion_producto, cantidad, precio_unitario, subtotal_producto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, d.getId_cotizacion());
            ps.setInt(2, d.getId_producto());
            ps.setString(3, d.getDescripcion_producto());
            ps.setInt(4, d.getCantidad());
            ps.setDouble(5, d.getPrecio_unitario());
            ps.setDouble(6, d.getSubtotal_produto());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) d.setId_detalle_cotizacion(keys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarDetaleCotizacion(DetalleCotizacion d) {
        String sql = "DELETE FROM detalle_cotizacion WHERE id_detalle_cotizacion = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, d.getId_detalle_cotizacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public DetalleCotizacion consultarPorId(DetalleCotizacion filtro) {
        String sql = "SELECT * FROM detalle_cotizacion WHERE id_detalle_cotizacion = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filtro.getId_detalle_cotizacion());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

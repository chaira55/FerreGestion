package ferregestion.model.DAOImpl;

import ferregestion.model.DAO.ICotizacionDAO;
import ferregestion.entities.Cotizacion;
import ferregestion.conexion.ConexionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CotizacionImpl implements ICotizacionDAO {

    private Cotizacion mapear(ResultSet rs) throws SQLException {
        return new Cotizacion(
                rs.getInt("id_cotizacion"),
                rs.getInt("cedula"),
                rs.getString("nombre"),
                rs.getDate("fecha").toLocalDate(),
                rs.getDouble("total")
        );
    }

    @Override
    public List<Cotizacion> consultarCotizacion() {
        List<Cotizacion> lista = new ArrayList<>();
        String sql =
                "SELECT co.id_cotizacion, co.cedula, cl.nombre, co.fecha, co.total " +
                        "FROM cotizacion co INNER JOIN cliente cl ON cl.cedula = co.cedula " +
                        "ORDER BY co.id_cotizacion DESC";
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
    public List<Cotizacion> consultarPorCliente(Cotizacion filtro) {
        List<Cotizacion> lista = new ArrayList<>();
        String sql =
                "SELECT co.id_cotizacion, co.cedula, cl.nombre, co.fecha, co.total " +
                        "FROM cotizacion co INNER JOIN cliente cl ON cl.cedula = co.cedula " +
                        "WHERE co.cedula = ? ORDER BY co.id_cotizacion DESC";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, filtro.getCedula());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Cotizacion> consultarPorFecha(Cotizacion filtro) {
        List<Cotizacion> lista = new ArrayList<>();
        String sql =
                "SELECT co.id_cotizacion, co.cedula, cl.nombre, co.fecha, co.total " +
                        "FROM cotizacion co INNER JOIN cliente cl ON cl.cedula = co.cedula " +
                        "WHERE co.fecha = ? ORDER BY co.id_cotizacion DESC";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(filtro.getFecha()));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) lista.add(mapear(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Cotizacion consultarPorId(int idCotizacion) {
        String sql =
                "SELECT co.id_cotizacion, co.cedula, cl.nombre, co.fecha, co.total " +
                        "FROM cotizacion co INNER JOIN cliente cl ON cl.cedula = co.cedula " +
                        "WHERE co.id_cotizacion = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idCotizacion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapear(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean modificarActualizacion(Cotizacion c) {
        String sql = "UPDATE cotizacion SET cedula = ?, fecha = ?, total = ? WHERE id_cotizacion = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, c.getCedula());
            ps.setDate(2, Date.valueOf(c.getFecha()));
            ps.setDouble(3, c.getTotal());
            ps.setInt(4, c.getId_cotizacion());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarCotizacion(int id_cotizacion) {
        String sql = "DELETE FROM cotizacion WHERE id_cotizacion = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id_cotizacion);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean agregarCotizacion(Cotizacion c) {
        String sql = "INSERT INTO cotizacion (cedula, nombre, fecha, total) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, c.getCedula());
            ps.setString(2, c.getNombre());   // ← nombre ahora sí
            ps.setDate(3, Date.valueOf(c.getFecha()));
            ps.setDouble(4, c.getTotal());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                try (ResultSet keys = ps.getGeneratedKeys()) {
                    if (keys.next()) c.setId_cotizacion(keys.getInt(1));
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

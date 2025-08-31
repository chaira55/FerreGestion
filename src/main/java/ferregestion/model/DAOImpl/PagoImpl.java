package ferregestion.model.DAOImpl;

import ferregestion.entities.Pago;
import ferregestion.model.DAO.IPagoDAO;
import ferregestion.conexion.ConexionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagoImpl implements IPagoDAO {

    @Override
    public List<Pago> consultarTodos() {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pago";
        try (Connection conn = ConexionBD.getConexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pago pago = new Pago(
                        rs.getInt("id_pago"),
                        rs.getInt("id_credito"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_pago").toLocalDate(),
                        rs.getDouble("monto")
                );
                lista.add(pago);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Pago> consultarCliente(Pago pago) {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pago WHERE cedula=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pago.getCedula());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Pago(
                            rs.getInt("id_pago"),
                            rs.getInt("id_credito"),
                            rs.getInt("cedula"),
                            rs.getString("nombre"),
                            rs.getDate("fecha_pago").toLocalDate(),
                            rs.getDouble("monto")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Pago> consultarPorFecha(Pago pago) {
        List<Pago> lista = new ArrayList<>();
        String sql = "SELECT * FROM pago WHERE fecha_pago=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(pago.getFecha_pago()));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Pago(
                            rs.getInt("id_pago"),
                            rs.getInt("id_credito"),
                            rs.getInt("cedula"),
                            rs.getString("nombre"),
                            rs.getDate("fecha_pago").toLocalDate(),
                            rs.getDouble("monto")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean agregarPago(Pago pago) {
        String sql = "INSERT INTO pago (id_credito, cedula, nombre, fecha_pago, monto) VALUES (?,?,?,?,?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pago.getId_credito());
            ps.setInt(2, pago.getCedula());
            ps.setString(3, pago.getNombre());
            ps.setDate(4, Date.valueOf(pago.getFecha_pago()));
            ps.setDouble(5, pago.getMonto());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modificarPago(Pago pago) {
        String sql = "UPDATE pago SET id_credito=?, cedula=?, nombre=?, fecha_pago=?, monto=? WHERE id_pago=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pago.getId_credito());
            ps.setInt(2, pago.getCedula());
            ps.setString(3, pago.getNombre());
            ps.setDate(4, Date.valueOf(pago.getFecha_pago()));
            ps.setDouble(5, pago.getMonto());
            ps.setInt(6, pago.getId_pago());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarPago(Pago pago) {
        String sql = "DELETE FROM pago WHERE id_pago=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pago.getId_pago());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

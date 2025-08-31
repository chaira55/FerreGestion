package ferregestion.model.DAOImpl;

import ferregestion.entities.Credito;
import ferregestion.model.DAO.ICreditoDAO;
import ferregestion.conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreditoImpl implements ICreditoDAO {

    @Override
    public List<Credito> consultarCreditos() {
        List<Credito> lista = new ArrayList<>();
        String sql = "SELECT * FROM credito";
        try (Connection conn = ConexionBD.getConexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Credito(
                        rs.getInt("id_credito"),
                        rs.getInt("id_venta"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getDouble("monto_total"),
                        rs.getDouble("saldo_pendiente")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Credito> consultarPorCliente(Credito credito) {
        List<Credito> lista = new ArrayList<>();
        String sql = "SELECT * FROM credito WHERE cedula = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, credito.getCedula());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Credito(
                        rs.getInt("id_credito"),
                        rs.getInt("id_venta"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getDouble("monto_total"),
                        rs.getDouble("saldo_pendiente")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean agregarCredito(Credito credito) {
        String sql = "INSERT INTO credito (id_venta, cedula, nombre, monto_total, saldo_pendiente) VALUES (?,?,?,?,?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, credito.getId_venta());
            ps.setInt(2, credito.getCedula());
            ps.setString(3, credito.getNombre());
            ps.setDouble(4, credito.getMonto_total());
            ps.setDouble(5, credito.getSaldo_pendiente());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modificarCredito(Credito credito) {
        String sql = "UPDATE credito SET monto_total=?, saldo_pendiente=? WHERE id_credito=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, credito.getMonto_total());
            ps.setDouble(2, credito.getSaldo_pendiente());
            ps.setInt(3, credito.getId_credito());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean actualizarSaldo(Credito credito) {
        String sql = "UPDATE credito SET saldo_pendiente=? WHERE id_credito=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, credito.getSaldo_pendiente());
            ps.setInt(2, credito.getId_credito());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarCredito(Credito credito) {
        String sql = "DELETE FROM credito WHERE id_credito=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, credito.getId_credito());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

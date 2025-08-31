package ferregestion.model.DAOImpl;

import ferregestion.conexion.ConexionBD;
import ferregestion.entities.Venta;
import ferregestion.model.DAO.IVentaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaImpl implements IVentaDAO {

    @Override
    public List<Venta> consultarVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Venta v = new Venta(
                        rs.getInt("id_venta"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("id_cotizacion"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("total"),
                        rs.getString("tipo_pago")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Venta> consultarPorCliente(Venta venta) {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta WHERE cedula = ?";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venta.getCedula());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venta v = new Venta(
                        rs.getInt("id_venta"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("id_cotizacion"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("total"),
                        rs.getString("tipo_pago")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Venta> consultarPorFecha(Venta venta) {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta WHERE fecha = ?";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(venta.getFecha()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Venta v = new Venta(
                        rs.getInt("id_venta"),
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getInt("id_cotizacion"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("total"),
                        rs.getString("tipo_pago")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean eliminarVenta(Venta venta) {
        String sql = "DELETE FROM venta WHERE id_venta = ?";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venta.getId_venta());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarVenta(Venta venta) {
        String sql = "INSERT INTO venta (cedula, nombre, id_cotizacion, fecha, total, tipo_pago) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venta.getCedula());
            ps.setString(2, venta.getNombre());
            ps.setInt(3, venta.getId_cotizacion());
            ps.setDate(4, Date.valueOf(venta.getFecha()));
            ps.setDouble(5, venta.getTotal());
            ps.setString(6, venta.getTipo_pago());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean modificarVenta(Venta venta) {
        String sql = "UPDATE venta SET cedula=?, nombre=?, id_cotizacion=?, fecha=?, total=?, tipo_pago=? WHERE id_venta=?";
        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venta.getCedula());
            ps.setString(2, venta.getNombre());
            ps.setInt(3, venta.getId_cotizacion());
            ps.setDate(4, Date.valueOf(venta.getFecha()));
            ps.setDouble(5, venta.getTotal());
            ps.setString(6, venta.getTipo_pago());
            ps.setInt(7, venta.getId_venta());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

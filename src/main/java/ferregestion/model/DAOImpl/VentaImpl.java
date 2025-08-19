package ferregestion.model.DAOImpl;

import ferregestion.entities.Venta;
import ferregestion.model.DAO.IVentaDAO;
import ferregestion.conexion.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaImpl implements IVentaDAO {

    @Override
    public List<Venta> consultarVentas() {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas";

        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId_venta(rs.getInt("id_venta"));
                venta.setCedula(rs.getInt("id_cliente"));
                venta.setFecha(rs.getDate("fecha").toLocalDate());
                venta.setTotal(rs.getDouble("total"));
                lista.add(venta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Venta> consultarPorCliente(Venta venta) {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE id_cliente = ?";

        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venta.getCedula());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Venta v = new Venta();
                    v.setId_venta(rs.getInt("id_venta"));
                    v.setCedula(rs.getInt("id_cliente"));
                    v.setFecha(rs.getDate("fecha").toLocalDate());
                    v.setTotal(rs.getDouble("total"));
                    lista.add(v);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Venta> consultarPorFecha(Venta venta) {
        List<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas WHERE fecha = ?";

        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(venta.getFecha()));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Venta v = new Venta();
                    v.setId_venta(rs.getInt("id_venta"));
                    v.setCedula(rs.getInt("id_cliente"));
                    v.setFecha(rs.getDate("fecha").toLocalDate());
                    v.setTotal(rs.getDouble("total"));
                    lista.add(v);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean eliminarVenta(Venta venta) {
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
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
        String sql = "INSERT INTO ventas (id_cliente, fecha, total) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.getConexionBD();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venta.getCedula());
            ps.setDate(2, java.sql.Date.valueOf(venta.getFecha()));
            ps.setDouble(3, venta.getTotal());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

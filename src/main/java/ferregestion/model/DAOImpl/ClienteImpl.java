package ferregestion.model.DAOImpl;

import ferregestion.model.DAO.IClienteDAO;
import ferregestion.entities.Cliente;
import ferregestion.conexion.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements IClienteDAO {

    @Override
    public List<Cliente> consultarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = ConexionBD.getConexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("cedula"),
                        rs.getString("nombre"),
                        rs.getString("celular"),
                        rs.getString("direccion"),
                        rs.getString("correo")
                        );
                lista.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean buscarClientePorCedula(Cliente cliente) {
        String sql = "SELECT * FROM cliente WHERE cedula = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getCedula());
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (cedula, nombre, celular, direccion, correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getCedula());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getCelular());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setString(5, cliente.getCorreo());
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET cedula=?, nombre=?, celular=?, direccion=?, correo=? WHERE cedula=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getCedula());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getCelular());
            pstmt.setString(4, cliente.getDireccion());
            pstmt.setString(5, cliente.getCorreo());
            pstmt.setInt(6, cliente.getCedula()); // ← Este faltaba

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        String sql = "DELETE FROM cliente WHERE cedula=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, cliente.getCedula());
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cliente consultarPorNombre(String nombre) {
        String sql = "SELECT * FROM cliente WHERE nombre=?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(
                            rs.getInt("cedula"),
                            rs.getString("nombre"),
                            rs.getString("celular"),
                            rs.getString("direccion"),
                            rs.getString("correo")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

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
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionBD.getConexionBD();
        String sql = "SELECT * FROM cliente";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCedula(rs.getInt("cedula"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
            }
        }catch (Exception e){
                System.out.println("Error al listar clientes: " + e.getMessage());
        }

        finally {
                try{
                    con.close();
                }catch (Exception e){
                    System.out.println("Error al cerrar conexion: " + e.getMessage());
                }
            }
            return clientes;
        }

    @Override
    public Cliente buscarClientePorCedula(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionBD.getConexionBD();
        String sql = "SELECT * FROM cliente WHERE cedula = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getCedula());
            rs = ps.executeQuery();
            if (rs.next()){
                cliente.setCedula(rs.getInt("cedula"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
                return cliente;
            }
        }catch (Exception e){
            System.out.println("Error al listar clientes por nombre: " + e.getMessage());
        }

        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = ConexionBD.getConexionBD();
        String sql = "INSERT INTO cliente (cedula, nombre, celular, direccion, correo) VALUES (?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCorreo());
            ps.executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }

        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = ConexionBD.getConexionBD();
        String sql = "UPDATE cliente SET cedula=?, nombre=?, celular=?, direccion=?, correo=? WHERE cedula=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getCedula());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getCelular());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getCorreo());
            ps.setInt(6, cliente.getCedula());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error al modificar cliente: " + e.getMessage());
        }

        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = ConexionBD.getConexionBD();
        String sql = "DELETE FROM cliente WHERE cedula=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getCedula());
            ps.executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }

        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Cliente consultarPorNombre(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionBD.getConexionBD();
        String sql = "SELECT * FROM cliente WHERE nombre=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            rs = ps.executeQuery();
            if (rs.next()){
                cliente.setCedula(rs.getInt("cedula"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setCorreo(rs.getString("correo"));
                return cliente;
            }
        }catch (Exception e){
            System.out.println("Error al listar clientes por nombre: " + e.getMessage());
        }

        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return null;
    }
}

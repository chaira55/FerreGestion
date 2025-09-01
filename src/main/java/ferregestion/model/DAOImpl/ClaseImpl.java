package ferregestion.model.DAOImpl;

import ferregestion.conexion.ConexionBD;
import ferregestion.entities.Clase;
import ferregestion.model.DAO.IClaseDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClaseImpl implements IClaseDAO {

    @Override
    public List<Clase> consultarClases() {
        List<Clase> clases = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionBD.getConexionBD();
        String sql = "SELECT * FROM clase ORDER BY codigo_clase";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var clase = new Clase();
                clase.setCodigo_clase(rs.getString("codigo_clase"));
                clase.setNombre(rs.getString("nombre"));
            }
        }catch (Exception e){
            System.out.println("Error al listar clases: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return clases;
    }

    @Override
    public boolean agregarClase(Clase clase) {
        PreparedStatement ps;
        Connection con = ConexionBD.getConexionBD();
        String sql = "INSERT INTO clase (codigo_clase, nombre) VALUES (?, ?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getCodigo_clase());
            ps.setString(2, clase.getNombre());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error al agregar clase");
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
    public Clase consultarPorNombre(Clase clase) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConexionBD.getConexionBD();
        String sql = "SELECT * FROM clase WHERE nombre = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getCodigo_clase());
            rs = ps.executeQuery();
            if (rs.next()){
                clase.setCodigo_clase(rs.getString("codigo_cliente"));
                clase.setNombre(rs.getString("nombre"));
                return clase;
            }
        }catch (Exception e){
            System.out.println("Error al recuperar la clase por nombre: " + e.getMessage());
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
    public boolean modificarClase(Clase clase) {
        PreparedStatement ps;
        Connection con = ConexionBD.getConexionBD();
        String sql = "UPDATE clase SET nombre = ? WHERE codigo_clase = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getNombre());
            ps.setString(2, clase.getCodigo_clase());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
                System.out.println("Error al recuperar la clase por nombre: " + e.getMessage());
            }

        finally {
                try{
                    con.close();
                }catch (Exception e){
                    System.out.println("Error al cerrar conexion: " + e.getMessage());
                }
            }
            return false;
        }

    @Override
    public boolean eliminarClase(Clase clase) {
        PreparedStatement ps;
        Connection con = ConexionBD.getConexionBD();
        String sql = "DELETE FROM clase WHERE codigo_clase = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, clase.getCodigo_clase());
            ps.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println("Error al recuperar la clase por nombre: " + e.getMessage());
        }

        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }
}

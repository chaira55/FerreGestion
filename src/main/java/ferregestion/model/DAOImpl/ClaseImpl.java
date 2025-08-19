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
        String sql = "SELECT codigo_clase, nombre FROM clase";

        try (Connection conn = ConexionBD.getConexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Clase clase = new Clase(
                        rs.getString("codigo_clase"),
                        rs.getString("nombre")
                );
                clases.add(clase);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clases;
    }

    @Override
    public boolean agregarClase(Clase clase) {
        String sql = "INSERT INTO clase (codigo_clase, nombre) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, clase.getCodigo_clase());
            ps.setString(2, clase.getNombre());

            return ps.executeUpdate() > 0; // true si insertó

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Clase consultarPorNombre(Clase clase) {
        String sql = "SELECT codigo_clase, nombre FROM clase WHERE nombre = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, clase.getNombre());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Clase(
                        rs.getString("codigo_clase"),
                        rs.getString("nombre")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // no encontró
    }

    @Override
    public boolean modificarClase(Clase clase) {
        String sql = "UPDATE clase SET nombre = ? WHERE codigo_clase = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, clase.getNombre());
            ps.setString(2, clase.getCodigo_clase());

            return ps.executeUpdate() > 0; // true si modificó

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarClase(Clase clase) {
        String sql = "DELETE FROM clase WHERE codigo_clase = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, clase.getCodigo_clase());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

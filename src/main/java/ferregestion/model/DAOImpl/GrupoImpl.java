package ferregestion.model.DAOImpl;

import ferregestion.conexion.ConexionBD;
import ferregestion.entities.Grupo;
import ferregestion.model.DAO.IGrupoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrupoImpl implements IGrupoDAO {

    @Override
    public List<Grupo> consultarGrupos() {
        List<Grupo> grupos = new ArrayList<>();
        String sql = "SELECT codigo_grupo, nombre, iva FROM grupo";

        try (Connection conn = ConexionBD.getConexionBD();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Grupo grupo = new Grupo(
                        rs.getString("codigo_grupo"),
                        rs.getString("nombre"),
                        rs.getDouble("iva")
                );
                grupos.add(grupo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grupos;
    }

    @Override
    public boolean actualizarGrupo(Grupo grupo) {
        String sql = "UPDATE grupo SET nombre = ?, iva = ? WHERE codigo_grupo = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, grupo.getNombre());
            ps.setDouble(2, grupo.getIva());
            ps.setString(3, grupo.getCodigo_grupo());

            return ps.executeUpdate() > 0; // true si se actualizó

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean eliminarGrupo(Grupo grupo) {
        String sql = "DELETE FROM grupo WHERE codigo_grupo = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, grupo.getCodigo_grupo());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean agregarGrupo(Grupo grupo) {
        String sql = "INSERT INTO grupo (codigo_grupo, nombre, iva) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, grupo.getCodigo_grupo());
            ps.setString(2, grupo.getNombre());
            ps.setDouble(3, grupo.getIva());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Grupo consultarPorId(Grupo grupo) {
        String sql = "SELECT codigo_grupo, nombre, iva FROM grupo WHERE codigo_grupo = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, grupo.getCodigo_grupo());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Grupo(
                        rs.getString("codigo_grupo"),
                        rs.getString("nombre"),
                        rs.getDouble("iva")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Grupo consultarPorNombre(Grupo grupo) {
        String sql = "SELECT codigo_grupo, nombre, iva FROM grupo WHERE nombre = ?";
        try (Connection conn = ConexionBD.getConexionBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, grupo.getNombre());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Grupo(
                        rs.getString("codigo_grupo"),
                        rs.getString("nombre"),
                        rs.getDouble("iva")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

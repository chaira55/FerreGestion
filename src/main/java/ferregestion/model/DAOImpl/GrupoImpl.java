package ferregestion.model.DAOImpl;

import ferregestion.entities.Grupo;
import ferregestion.model.DAO.IGrupoDAO;

import java.util.List;

public class GrupoImpl implements IGrupoDAO {
    @Override
    public List<Grupo> consultarGrupos() {
        return List.of();
    }

    @Override
    public boolean actualizarGrupo(Grupo grupo) {
        return false;
    }

    @Override
    public boolean eliminarGrupo(Grupo grupo) {
        return false;
    }

    @Override
    public boolean agregarGrupo(Grupo grupo) {
        return false;
    }

    @Override
    public Grupo consultarPorId(Grupo grupo) {
        return null;
    }

    @Override
    public Grupo consultarPorNombre(Grupo grupo) {
        return null;
    }
}

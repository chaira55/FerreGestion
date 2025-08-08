package ferregestion.model.DAO;

import ferregestion.entities.Grupo;

import java.util.List;

public interface IGrupoDAO {
    List<Grupo> consultarGrupos();
    boolean actualizarGrupo(Grupo grupo);
    boolean eliminarGrupo(Grupo grupo);
    boolean agregarGrupo(Grupo grupo);
    Grupo consultarPorId(Grupo grupo);
    Grupo consultarPorNombre(Grupo grupo);
}

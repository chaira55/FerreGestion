package ferregestion.model.DAOImpl;

import ferregestion.entities.Clase;
import ferregestion.model.DAO.IClaseDAO;

import java.util.List;

public class ClaseImpl implements IClaseDAO {
    @Override
    public List<Clase> consultarClases() {
        return List.of();
    }

    @Override
    public boolean agregarClase(Clase clase) {
        return false;
    }

    @Override
    public Clase consultarPorNombre(Clase clase) {
        return null;
    }

    @Override
    public boolean modificarClase(Clase clase) {
        return false;
    }

    @Override
    public boolean eliminarClase(Clase clase) {
        return false;
    }
}

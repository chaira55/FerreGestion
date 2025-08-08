package ferregestion.model.DAO;

import ferregestion.entities.Clase;
import java.util.List;

public interface IClaseDAO {
    List<Clase> consultarClases();
    boolean agregarClase(Clase clase);
    Clase consultarPorNombre(Clase clase);
    boolean modificarClase(Clase clase);
    boolean eliminarClase(Clase clase);
}

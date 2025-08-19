package ferregestion.view;

import ferregestion.entities.Grupo;
import ferregestion.model.DAOImpl.GrupoImpl;

public class PruebaGrupo {
    public static void main(String[] args) {
        GrupoImpl dao = new GrupoImpl();

        // Agregar
        dao.agregarGrupo(new Grupo("G001", "Herramientas", 19.0));
/*
        // Consultar
        System.out.println(dao.consultarGrupos());

        // Actualizar
        dao.actualizarGrupo(new Grupo("G001", "Herramientas Manuales", 19.0));

        // Consultar por ID
        System.out.println(dao.consultarPorId(new Grupo("G001", null, 0)));

        // Eliminar
        dao.eliminarGrupo(new Grupo("G001", null, 0));
*/    }
}

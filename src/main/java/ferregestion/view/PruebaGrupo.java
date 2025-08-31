package ferregestion.view;

import ferregestion.entities.Grupo;
import ferregestion.model.DAOImpl.GrupoImpl;

public class PruebaGrupo {
    public static void main(String[] args) {
        GrupoImpl dao = new GrupoImpl();

        // Agregar
        dao.agregarGrupo(new Grupo("G001", "Herramientas", 19.0));       // Clase C001
        dao.agregarGrupo(new Grupo("G002", "Materiales", 5.0));         // Clase C001
        dao.agregarGrupo(new Grupo("G003", "Brochas y Rodillos", 19.0));// Clase C002
        dao.agregarGrupo(new Grupo("G004", "Cables y Accesorios", 19.0));// Clase C003
        dao.agregarGrupo(new Grupo("G005", "Tubos y Conexiones", 19.0));// Clase C004
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

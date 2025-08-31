package ferregestion.view;

import ferregestion.entities.Clase;
import ferregestion.model.DAOImpl.ClaseImpl;

public class PruebaClase {
    public static void main(String[] args) {
        ClaseImpl dao = new ClaseImpl();

        // Agregar
        dao.agregarClase(new Clase("C001", "Construcción"));
        dao.agregarClase(new Clase("C002", "Pintura"));
        dao.agregarClase(new Clase("C003", "Electricidad"));
        dao.agregarClase(new Clase("C004", "Fontanería"));

        // Consultar todas
        //System.out.println(dao.consultarClases());
/*
        // Consultar por nombre
        System.out.println(dao.consultarPorNombre(new Clase(null, "Construcción")));

        // Modificar
        dao.modificarClase(new Clase("C001", "Materiales de Construcción"));

        // Eliminar
        dao.eliminarClase(new Clase("C001", null));
 */   }
}

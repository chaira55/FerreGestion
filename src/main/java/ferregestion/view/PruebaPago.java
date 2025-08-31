package ferregestion.view;

import ferregestion.entities.Pago;
import ferregestion.model.DAOImpl.PagoImpl;

import java.time.LocalDate;
import java.util.List;

public class PruebaPago {
    public static void main(String[] args) {
        PagoImpl dao = new PagoImpl();
        List<Pago> lista = dao.consultarTodos();


        // Agregar pago
        Pago nuevo = new Pago(2, 123456789, "Juan Pérez", LocalDate.now(), 150000.0);
        boolean insertado = dao.agregarPago(nuevo);
        System.out.println("Pago insertado: " + insertado);
/*
        // Consultar todos
        lista.forEach(System.out::println);


        // Modificar pago
        if (!lista.isEmpty()) {
            Pago primero = lista.get(0);
            primero.setMonto(200000.0);
            boolean modificado = dao.modificarPago(primero);
            System.out.println("Pago modificado: " + modificado);
        }

        /*
        // Eliminar pago
        if (!lista.isEmpty()) {
            Pago ultimo = lista.get(lista.size() - 1);
            boolean eliminado = dao.eliminarPago(ultimo);
            System.out.println("Pago eliminado: " + eliminado);
        }

        // Consultar por cliente
        Pago filtroCliente = new Pago();
        filtroCliente.setCedula(123456789);
        List<Pago> porCliente = dao.consultarCliente(filtroCliente);
        porCliente.forEach(p -> System.out.println("Por cliente: " + p));

        // Consultar por fecha
        Pago filtroFecha = new Pago();
        filtroFecha.setFecha_pago(LocalDate.now());
        List<Pago> porFecha = dao.consultarPorFecha(filtroFecha);
        porFecha.forEach(p -> System.out.println("Por fecha: " + p));
        */
    }
}

package ferregestion.view;

import ferregestion.entities.Credito;
import ferregestion.model.DAOImpl.CreditoImpl;

import java.util.List;

public class PruebaCredito {
    public static void main(String[] args) {
        CreditoImpl dao = new CreditoImpl();
        List<Credito> lista = dao.consultarCreditos();


        // Agregar crédito
        Credito nuevo = new Credito(2, 123456789, "Juan Pérez", 500000.0, 500000.0);
        boolean insertado = dao.agregarCredito(nuevo);
        System.out.println("Crédito insertado: " + insertado);
/*
        // Consultar todos
        lista.forEach(System.out::println);

        // Modificar crédito (ejemplo: cambiar saldo pendiente)
        if (!lista.isEmpty()) {
            Credito primero = lista.get(0);
            primero.setSaldo_pendiente(250000.0);
            boolean modificado = dao.modificarCredito(primero);
            System.out.println("Crédito modificado: " + modificado);
        }


        // Actualizar saldo
        if (!lista.isEmpty()) {
            Credito primero = lista.get(0);
            primero.setSaldo_pendiente(0.0);
            boolean actualizado = dao.actualizarSaldo(primero);
            System.out.println("Saldo actualizado: " + actualizado);
        }

        // Eliminar crédito
        if (!lista.isEmpty()) {
            Credito ultimo = lista.get(lista.size() - 1); // el último de la BD
            boolean eliminado = dao.eliminarCredito(ultimo);
            System.out.println("Crédito eliminado: " + eliminado);
        }

        // Consultar por cliente
        Credito filtroCliente = new Credito();
        filtroCliente.setCedula(123456789);
        List<Credito> porCliente = dao.consultarPorCliente(filtroCliente);
        porCliente.forEach(c -> System.out.println("Por cliente: " + c));
        */
    }
}

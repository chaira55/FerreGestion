package ferregestion.view;

import ferregestion.entities.Cliente;
import ferregestion.model.DAOImpl.ClienteImpl;
import java.util.List;

public class PruebaCliente {
    public static void main(String[] args) {
        ClienteImpl dao = new ClienteImpl();

        //agregar cliente
        Cliente nuevoCliente = new Cliente(123456789, "Juan Pérez", "3001234567", "Calle 123", "sharik@gmail.com");
        dao.agregarCliente(nuevoCliente);

        //consultar clientes
        List<Cliente> lista = dao.consultarClientes();
        System.out.println("\nLista de clientes:");
        for (Cliente c : lista) {
            System.out.println(c);
        }

        //buscar cliente por cédula
        Cliente clienteCedula = new Cliente();
        clienteCedula.setCedula(123456789);
        Cliente encontradoPorCedula = dao.consultarPorNombre(clienteCedula);
        System.out.println(encontradoPorCedula);

        //modificar cliente
        Cliente clienteModificado = new Cliente(123456789, "Juan Pérez", "3119876543", "Carrera 45", "sharik@gmail.com");
        dao.modificarCliente(clienteModificado);

        //consultar por nombre
        Cliente clienteBusqueda = new Cliente();
        clienteBusqueda.setNombre("Juan Peréz");
        Cliente encontradoPorNombre = dao.consultarPorNombre(clienteBusqueda);
        System.out.println(encontradoPorNombre);

        //eliminar cliente
        Cliente clienteEliminar = new Cliente();
        clienteEliminar.setCedula(123456789);
        dao.eliminarCliente(clienteEliminar);
    }
}

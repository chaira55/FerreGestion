package ferregestion.view;

import ferregestion.entities.Cliente;
import ferregestion.model.DAOImpl.ClienteImpl;
import java.util.List;

public class Pruebas {
    public static void main(String[] args) {
        ClienteImpl dao = new ClienteImpl();

        // ===================== 1️⃣ Agregar cliente =====================
        Cliente nuevoCliente = new Cliente(123456789, "Juan Pérez", "3001234567", "Calle 123", "sharik@gmail.com");
        if (dao.agregarCliente(nuevoCliente)) {
            System.out.println("✅ Cliente agregado correctamente");
        } else {
            System.out.println("❌ No se pudo agregar el cliente");
        }

        // ===================== 2️⃣ Consultar todos =====================
        List<Cliente> lista = dao.consultarClientes();
        System.out.println("\n📋 Lista de clientes:");
        for (Cliente c : lista) {
            System.out.println(c);
        }

        // ===================== 3️⃣ Buscar cliente por cédula =====================
        Cliente clienteBusqueda = new Cliente();
        clienteBusqueda.setCedula(123456789);
        if (dao.buscarClientePorCedula(clienteBusqueda)) {
            System.out.println("\n🔍 Cliente encontrado: " + clienteBusqueda);
        } else {
            System.out.println("\n❌ Cliente no encontrado");
        }

        // ===================== 4️⃣ Modificar cliente =====================
        Cliente clienteModificado = new Cliente(123456789, "Juan Pérez", "3119876543", "Carrera 45", "sharik@gmail.com");
        if (dao.modificarCliente(clienteModificado)) {
            System.out.println("✅ Cliente modificado correctamente");
        } else {
            System.out.println("❌ No se pudo modificar el cliente");
        }

        // ===================== 5️⃣ Consultar por nombre =====================
        Cliente encontradoPorNombre = dao.consultarPorNombre("Juan Pérez");
        if (encontradoPorNombre != null) {
            System.out.println("\n📛 Cliente encontrado por nombre: " + encontradoPorNombre);
        } else {
            System.out.println("\n❌ Cliente no encontrado por nombre");
        }

        // ===================== 6️⃣ Eliminar cliente =====================
        Cliente clienteEliminar = new Cliente();
        clienteEliminar.setCedula(123456789);
        if (dao.eliminarCliente(clienteEliminar)) {
            System.out.println("✅ Cliente eliminado correctamente");
        } else {
            System.out.println("❌ No se pudo eliminar el cliente");
        }

        // ===================== 7️⃣ Ver lista final =====================
        List<Cliente> listaFinal = dao.consultarClientes();
        System.out.println("\n📋 Lista final de clientes:");
        for (Cliente c : listaFinal) {
            System.out.println(c);
        }
    }
}

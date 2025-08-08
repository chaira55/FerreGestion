package ferregestion.model.DAO;

import ferregestion.entities.Cliente;
import java.util.List;

public interface IClienteDAO {
    List<Cliente> consultarClientes();
    boolean buscarClientePorCedula(Cliente cliente);
    boolean agregarCliente(Cliente cliente);
    boolean modificarCliente(Cliente cliente);
    boolean eliminarCliente(Cliente cliente);
    Cliente consultarPorCedula(int cedula);
    Cliente consultarPorNombre(String nombre);
}

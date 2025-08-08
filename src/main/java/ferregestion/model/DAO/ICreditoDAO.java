package ferregestion.model.DAO;

import ferregestion.entities.Credito;

import java.util.List;

public interface ICreditoDAO {
    List<Credito> consultarCreditos();
    List<Credito> consultarPorCliente(Credito credito);
    boolean agregarCredito(Credito credito);
    boolean modificarCredito(Credito credito);
    boolean actualizarSaldo(Credito credito);
    boolean eliminarCredito(Credito credito);

}

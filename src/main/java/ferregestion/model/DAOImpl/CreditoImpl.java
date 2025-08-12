package ferregestion.model.DAOImpl;

import ferregestion.entities.Credito;
import ferregestion.model.DAO.ICreditoDAO;

import java.util.List;

public class CreditoImpl implements ICreditoDAO {
    @Override
    public List<Credito> consultarCreditos() {
        return List.of();
    }

    @Override
    public List<Credito> consultarPorCliente(Credito credito) {
        return List.of();
    }

    @Override
    public boolean agregarCredito(Credito credito) {
        return false;
    }

    @Override
    public boolean modificarCredito(Credito credito) {
        return false;
    }

    @Override
    public boolean actualizarSaldo(Credito credito) {
        return false;
    }

    @Override
    public boolean eliminarCredito(Credito credito) {
        return false;
    }
}

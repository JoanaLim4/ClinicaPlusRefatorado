package clinicaplus.repository;

import clinicaplus.model.Medico;
import java.util.List;
import java.util.Optional;

public interface MedicoRepository {
    void salvar(Medico medico);
    Optional<Medico> buscarPorCrm(String crm);
    List<Medico> listarTodos();
}

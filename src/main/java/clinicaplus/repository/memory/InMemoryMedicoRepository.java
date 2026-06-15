package clinicaplus.repository.memory;

import clinicaplus.model.Medico;
import clinicaplus.repository.MedicoRepository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryMedicoRepository implements MedicoRepository {
    private final Map<String, Medico> medicos = new LinkedHashMap<>();

    @Override
    public void salvar(Medico medico) {
        medicos.put(medico.getCrm(), medico);
    }

    @Override
    public Optional<Medico> buscarPorCrm(String crm) {
        return Optional.ofNullable(medicos.get(crm));
    }

    @Override
    public List<Medico> listarTodos() {
        return new ArrayList<>(medicos.values());
    }
}

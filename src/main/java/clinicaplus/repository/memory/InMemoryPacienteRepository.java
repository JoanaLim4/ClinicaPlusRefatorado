package clinicaplus.repository.memory;

import clinicaplus.model.Paciente;
import clinicaplus.repository.PacienteRepository;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPacienteRepository implements PacienteRepository {
    private final Map<String, Paciente> pacientes = new LinkedHashMap<>();

    @Override
    public void salvar(Paciente paciente) {
        pacientes.put(paciente.getCpf(), paciente);
    }

    @Override
    public Optional<Paciente> buscarPorCpf(String cpf) {
        return Optional.ofNullable(pacientes.get(cpf));
    }

    @Override
    public List<Paciente> listarTodos() {
        return new ArrayList<>(pacientes.values());
    }
}

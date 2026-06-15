package clinicaplus.repository;

import clinicaplus.model.Paciente;
import java.util.List;
import java.util.Optional;

public interface PacienteRepository {
    void salvar(Paciente paciente);
    Optional<Paciente> buscarPorCpf(String cpf);
    List<Paciente> listarTodos();
}

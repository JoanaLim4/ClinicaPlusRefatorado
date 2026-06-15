package clinicaplus.service;

import clinicaplus.model.Paciente;
import clinicaplus.repository.PacienteRepository;
import java.util.List;
import java.util.Optional;

public class PacienteService {
    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente cadastrar(String cpf, String nome, String telefone) {
        Validador.obrigatorio(cpf, "CPF");
        Validador.obrigatorio(nome, "nome");
        Validador.obrigatorio(telefone, "telefone");

        Paciente paciente = new Paciente(cpf.trim(), nome.trim(), telefone.trim());
        pacienteRepository.salvar(paciente);
        return paciente;
    }

    public Optional<Paciente> buscarPorCpf(String cpf) {
        Validador.obrigatorio(cpf, "CPF");
        return pacienteRepository.buscarPorCpf(cpf.trim());
    }

    public List<Paciente> listarTodos() {
        return pacienteRepository.listarTodos();
    }
}

package br.com.clinicaplus.service;

import br.com.clinicaplus.model.Paciente;
import br.com.clinicaplus.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacienteService {
    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listar() {
        return repository.findAll();
    }

    public Paciente buscarPorCpf(String cpf) {
        return repository.findById(cpf).orElse(null);
    }
}

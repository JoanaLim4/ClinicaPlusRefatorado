package clinicaplus.service;

import clinicaplus.exception.ValidacaoException;
import clinicaplus.model.Consulta;
import clinicaplus.repository.ConsultaRepository;
import clinicaplus.repository.MedicoRepository;
import clinicaplus.repository.PacienteRepository;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaService {
    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaService(ConsultaRepository consultaRepository, PacienteRepository pacienteRepository, MedicoRepository medicoRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public Consulta agendar(String cpfPaciente, String crmMedico, LocalDateTime dataHora) {
        Validador.obrigatorio(cpfPaciente, "CPF do paciente");
        Validador.obrigatorio(crmMedico, "CRM do médico");
        if (dataHora == null) {
            throw new ValidacaoException("A data e hora da consulta são obrigatórias.");
        }
        pacienteRepository.buscarPorCpf(cpfPaciente.trim())
                .orElseThrow(() -> new ValidacaoException("Paciente não cadastrado."));
        medicoRepository.buscarPorCrm(crmMedico.trim())
                .orElseThrow(() -> new ValidacaoException("Médico não cadastrado."));

        Consulta consulta = new Consulta(cpfPaciente.trim(), crmMedico.trim(), dataHora);
        consultaRepository.salvar(consulta);
        return consulta;
    }

    public void cancelar(Consulta consulta) {
        if (consulta == null) {
            throw new ValidacaoException("Informe a consulta que será cancelada.");
        }
        consulta.cancelar();
    }

    public List<Consulta> listarTodas() {
        return consultaRepository.listarTodas();
    }

    public List<Consulta> listarPorCpfPaciente(String cpfPaciente) {
        Validador.obrigatorio(cpfPaciente, "CPF do paciente");
        return consultaRepository.listarPorCpfPaciente(cpfPaciente.trim());
    }
}

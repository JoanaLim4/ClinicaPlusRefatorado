package clinicaplus.service;

import clinicaplus.model.Medico;
import clinicaplus.repository.MedicoRepository;
import java.util.List;
import java.util.Optional;

public class MedicoService {
    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public Medico cadastrar(String cpf, String crm, String nome, String especialidade, String telefone, String email) {
        Validador.obrigatorio(cpf, "CPF");
        Validador.obrigatorio(crm, "CRM");
        Validador.obrigatorio(nome, "nome");
        Validador.obrigatorio(especialidade, "especialidade");
        Validador.obrigatorio(telefone, "telefone");
        Validador.obrigatorio(email, "e-mail");

        Medico medico = new Medico(cpf.trim(), crm.trim(), nome.trim(), especialidade.trim(), telefone.trim(), email.trim());
        medicoRepository.salvar(medico);
        return medico;
    }

    public Optional<Medico> buscarPorCrm(String crm) {
        Validador.obrigatorio(crm, "CRM");
        return medicoRepository.buscarPorCrm(crm.trim());
    }

    public List<Medico> listarTodos() {
        return medicoRepository.listarTodos();
    }
}

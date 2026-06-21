package br.com.clinicaplus.service;

import br.com.clinicaplus.model.Consulta;
import br.com.clinicaplus.repository.ConsultaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository repository;
    private final RegraConsulta regraConsulta = new RegraConsulta();

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta agendar(Consulta consulta) {
        if (!regraConsulta.horarioValido(consulta.getHorario())) {
            throw new IllegalArgumentException("Horário inválido. Use o formato HH:mm entre 07:00 e 18:59.");
        }
        consulta.setStatus("AGENDADA");
        return repository.save(consulta);
    }

    public List<Consulta> listar() {
        return repository.findAll();
    }

    public void cancelar(Long id) {
        Consulta consulta = repository.findById(id).orElseThrow();
        consulta.setStatus("CANCELADA");
        repository.save(consulta);
    }
}

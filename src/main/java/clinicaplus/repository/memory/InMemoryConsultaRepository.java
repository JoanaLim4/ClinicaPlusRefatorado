package clinicaplus.repository.memory;

import clinicaplus.model.Consulta;
import clinicaplus.repository.ConsultaRepository;
import java.util.ArrayList;
import java.util.List;

public class InMemoryConsultaRepository implements ConsultaRepository {
    private final List<Consulta> consultas = new ArrayList<>();

    @Override
    public void salvar(Consulta consulta) {
        consultas.add(consulta);
    }

    @Override
    public void remover(Consulta consulta) {
        consultas.remove(consulta);
    }

    @Override
    public List<Consulta> listarTodas() {
        return new ArrayList<>(consultas);
    }

    @Override
    public List<Consulta> listarPorCpfPaciente(String cpfPaciente) {
        return consultas.stream()
                .filter(consulta -> consulta.getCpfPaciente().equals(cpfPaciente))
                .toList();
    }
}

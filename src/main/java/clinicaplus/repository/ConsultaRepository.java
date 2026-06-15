package clinicaplus.repository;

import clinicaplus.model.Consulta;
import java.util.List;

public interface ConsultaRepository {
    void salvar(Consulta consulta);
    void remover(Consulta consulta);
    List<Consulta> listarTodas();
    List<Consulta> listarPorCpfPaciente(String cpfPaciente);
}

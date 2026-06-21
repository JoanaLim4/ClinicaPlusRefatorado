package br.com.clinicaplus.repository;

import br.com.clinicaplus.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByCpfPaciente(String cpfPaciente);
}

package br.com.clinicaplus.repository;

import br.com.clinicaplus.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}

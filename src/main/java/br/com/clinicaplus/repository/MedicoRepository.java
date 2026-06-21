package br.com.clinicaplus.repository;

import br.com.clinicaplus.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, String> {
}

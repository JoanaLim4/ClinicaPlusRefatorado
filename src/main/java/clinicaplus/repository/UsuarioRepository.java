package clinicaplus.repository;

import clinicaplus.model.Usuario;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorIdentificador(String identificador);
}

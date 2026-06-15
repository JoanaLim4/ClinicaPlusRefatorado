package clinicaplus.repository.memory;

import clinicaplus.model.PerfilUsuario;
import clinicaplus.model.Usuario;
import clinicaplus.repository.UsuarioRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryUsuarioRepository implements UsuarioRepository {
    private final Map<String, Usuario> usuarios = new HashMap<>();

    public InMemoryUsuarioRepository() {
        salvar(new Usuario("admin", "123", PerfilUsuario.ADMINISTRADOR));
        salvar(new Usuario("recepcao", "123", PerfilUsuario.RECEPCIONISTA));
        salvar(new Usuario("CRM001", "123", PerfilUsuario.DOUTOR));
    }

    public void salvar(Usuario usuario) {
        usuarios.put(usuario.getIdentificador(), usuario);
    }

    @Override
    public Optional<Usuario> buscarPorIdentificador(String identificador) {
        return Optional.ofNullable(usuarios.get(identificador));
    }
}

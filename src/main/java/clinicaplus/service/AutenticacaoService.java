package clinicaplus.service;

import clinicaplus.exception.ValidacaoException;
import clinicaplus.model.PerfilUsuario;
import clinicaplus.model.Usuario;
import clinicaplus.repository.UsuarioRepository;

public class AutenticacaoService {
    private final UsuarioRepository usuarioRepository;

    public AutenticacaoService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public PerfilUsuario autenticar(String identificador, String senha) {
        Validador.obrigatorio(identificador, "CPF ou CRM");
        Validador.obrigatorio(senha, "senha");

        Usuario usuario = usuarioRepository.buscarPorIdentificador(identificador.trim())
                .orElseThrow(() -> new ValidacaoException("Usuário não encontrado."));

        if (!usuario.getSenha().equals(senha.trim())) {
            throw new ValidacaoException("Senha inválida.");
        }
        return usuario.getPerfil();
    }
}

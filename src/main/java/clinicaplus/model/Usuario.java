package clinicaplus.model;

public class Usuario {
    private final String identificador;
    private final String senha;
    private final PerfilUsuario perfil;

    public Usuario(String identificador, String senha, PerfilUsuario perfil) {
        this.identificador = identificador;
        this.senha = senha;
        this.perfil = perfil;
    }

    public String getIdentificador() { return identificador; }
    public String getSenha() { return senha; }
    public PerfilUsuario getPerfil() { return perfil; }
}

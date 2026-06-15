package clinicaplus.model;

import java.util.Objects;

public class Medico {
    private final String cpf;
    private final String crm;
    private String nome;
    private String especialidade;
    private String telefone;
    private String email;

    public Medico(String cpf, String crm, String nome, String especialidade, String telefone, String email) {
        this.cpf = cpf;
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf() { return cpf; }
    public String getCrm() { return crm; }
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public String getTelefone() { return telefone; }
    public String getEmail() { return email; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Medico{crm='" + crm + "', nome='" + nome + "', especialidade='" + especialidade + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medico medico)) return false;
        return Objects.equals(crm, medico.crm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm);
    }
}

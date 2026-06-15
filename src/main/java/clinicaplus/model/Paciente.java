package clinicaplus.model;

import java.util.Objects;

public class Paciente {
    private final String cpf;
    private String nome;
    private String telefone;

    public Paciente(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return "Paciente{cpf='" + cpf + "', nome='" + nome + "', telefone='" + telefone + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente paciente)) return false;
        return Objects.equals(cpf, paciente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

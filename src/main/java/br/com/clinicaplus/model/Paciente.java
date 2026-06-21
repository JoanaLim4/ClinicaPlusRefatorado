package br.com.clinicaplus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Paciente {
    @Id
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    public Paciente() {}

    public Paciente(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}

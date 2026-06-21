package br.com.clinicaplus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Medico {
    @Id
    @NotBlank(message = "CRM é obrigatório")
    private String crm;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Especialidade é obrigatória")
    private String especialidade;

    private String telefone;
    private String email;

    public Medico() {}

    public Medico(String cpf, String crm, String nome, String especialidade, String telefone, String email) {
        this.cpf = cpf;
        this.crm = crm;
        this.nome = nome;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getCrm() { return crm; }
    public void setCrm(String crm) { this.crm = crm; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecialidade() { return especialidade; }
    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

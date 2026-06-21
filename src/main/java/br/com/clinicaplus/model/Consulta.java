package br.com.clinicaplus.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "CPF do paciente é obrigatório")
    private String cpfPaciente;

    @NotBlank(message = "Nome do paciente é obrigatório")
    private String nomePaciente;

    @NotBlank(message = "CRM do médico é obrigatório")
    private String crmMedico;

    @NotBlank(message = "Horário é obrigatório")
    private String horario;

    private String status = "AGENDADA";

    public Consulta() {}

    public Consulta(String cpfPaciente, String nomePaciente, String crmMedico, String horario) {
        this.cpfPaciente = cpfPaciente;
        this.nomePaciente = nomePaciente;
        this.crmMedico = crmMedico;
        this.horario = horario;
        this.status = "AGENDADA";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCpfPaciente() { return cpfPaciente; }
    public void setCpfPaciente(String cpfPaciente) { this.cpfPaciente = cpfPaciente; }

    public String getNomePaciente() { return nomePaciente; }
    public void setNomePaciente(String nomePaciente) { this.nomePaciente = nomePaciente; }

    public String getCrmMedico() { return crmMedico; }
    public void setCrmMedico(String crmMedico) { this.crmMedico = crmMedico; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

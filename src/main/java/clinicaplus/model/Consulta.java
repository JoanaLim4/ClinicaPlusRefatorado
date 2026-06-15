package clinicaplus.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Consulta {
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private final String cpfPaciente;
    private final String crmMedico;
    private LocalDateTime dataHora;
    private boolean cancelada;

    public Consulta(String cpfPaciente, String crmMedico, LocalDateTime dataHora) {
        this.cpfPaciente = cpfPaciente;
        this.crmMedico = crmMedico;
        this.dataHora = dataHora;
        this.cancelada = false;
    }

    public String getCpfPaciente() { return cpfPaciente; }
    public String getCrmMedico() { return crmMedico; }
    public LocalDateTime getDataHora() { return dataHora; }
    public boolean isCancelada() { return cancelada; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public void cancelar() { this.cancelada = true; }

    public String getHorarioFormatado() {
        return dataHora.format(FORMATADOR);
    }

    @Override
    public String toString() {
        return "Consulta{cpfPaciente='" + cpfPaciente + "', crmMedico='" + crmMedico + "', dataHora=" + getHorarioFormatado() + ", cancelada=" + cancelada + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consulta consulta)) return false;
        return Objects.equals(cpfPaciente, consulta.cpfPaciente)
                && Objects.equals(crmMedico, consulta.crmMedico)
                && Objects.equals(dataHora, consulta.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpfPaciente, crmMedico, dataHora);
    }
}

package br.com.clinicaplus.service;

public class RegraConsulta {
    public boolean horarioValido(String horario) {
        if (horario == null || !horario.matches("\\d{2}:\\d{2}")) {
            return false;
        }

        String[] partes = horario.split(":");
        int hora = Integer.parseInt(partes[0]);
        int minuto = Integer.parseInt(partes[1]);

        return hora >= 7 && hora <= 18 && minuto >= 0 && minuto <= 59;
    }
}

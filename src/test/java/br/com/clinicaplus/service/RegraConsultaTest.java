package br.com.clinicaplus.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RegraConsultaTest {
    @Test
    void deveAceitarHorarioDentroDoExpediente() {
        RegraConsulta regra = new RegraConsulta();
        assertTrue(regra.horarioValido("08:30"));
    }

    @Test
    void deveRecusarHorarioForaDoExpediente() {
        RegraConsulta regra = new RegraConsulta();
        assertFalse(regra.horarioValido("22:00"));
    }

    @Test
    void deveRecusarFormatoInvalido() {
        RegraConsulta regra = new RegraConsulta();
        assertFalse(regra.horarioValido("8h30"));
    }
}

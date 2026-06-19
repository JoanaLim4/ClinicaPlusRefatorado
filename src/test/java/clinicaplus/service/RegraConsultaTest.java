package clinicaplus.service;

import clinicaplus.exception.ValidacaoException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegraConsultaTest {

    @Test
    public void deveCalcularDuracaoDaConsultaEmMinutos() {
        RegraConsulta regra = new RegraConsulta();

        LocalDateTime inicio = LocalDateTime.of(2026, 6, 10, 9, 0);
        LocalDateTime fim = LocalDateTime.of(2026, 6, 10, 9, 30);

        long duracao = regra.calcularDuracaoEmMinutos(inicio, fim);

        assertEquals(30, duracao);
    }

    @Test
    public void deveValidarHorarioComercial() {
        RegraConsulta regra = new RegraConsulta();

        assertTrue(regra.horarioComercial(LocalDateTime.of(2026, 6, 10, 10, 0)));
        assertFalse(regra.horarioComercial(LocalDateTime.of(2026, 6, 10, 19, 0)));
    }

    @Test
    public void deveLancarErroQuandoFimForAntesDoInicio() {
        RegraConsulta regra = new RegraConsulta();

        LocalDateTime inicio = LocalDateTime.of(2026, 6, 10, 10, 0);
        LocalDateTime fim = LocalDateTime.of(2026, 6, 10, 9, 0);

        assertThrows(ValidacaoException.class, () -> regra.calcularDuracaoEmMinutos(inicio, fim));
    }
}

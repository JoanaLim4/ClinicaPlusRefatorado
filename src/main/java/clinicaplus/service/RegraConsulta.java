package clinicaplus.service;

import clinicaplus.exception.ValidacaoException;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Classe criada para concentrar regras simples de consulta.
 * Ela facilita a criação de testes unitários sem depender de banco de dados.
 */
public class RegraConsulta {

    public long calcularDuracaoEmMinutos(LocalDateTime inicio, LocalDateTime fim) {
        if (inicio == null || fim == null) {
            throw new ValidacaoException("Início e fim da consulta são obrigatórios.");
        }
        if (!fim.isAfter(inicio)) {
            throw new ValidacaoException("O fim da consulta deve ser depois do início.");
        }
        return Duration.between(inicio, fim).toMinutes();
    }

    public boolean horarioComercial(LocalDateTime dataHora) {
        if (dataHora == null) {
            throw new ValidacaoException("Data e hora são obrigatórias.");
        }
        int hora = dataHora.getHour();
        return hora >= 8 && hora < 18;
    }
}

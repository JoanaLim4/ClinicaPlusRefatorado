package clinicaplus.service;

import clinicaplus.exception.ValidacaoException;

public final class Validador {
    private Validador() { }

    public static void obrigatorio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidacaoException("O campo " + campo + " é obrigatório.");
        }
    }
}

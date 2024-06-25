package br.dev.andregurgel.gestao_vagas.exceptions;

public class CandidadeAlreadyExistsExeception extends RuntimeException {
    public CandidadeAlreadyExistsExeception() {
        super("Usuário ou email já existem.");
    }
}

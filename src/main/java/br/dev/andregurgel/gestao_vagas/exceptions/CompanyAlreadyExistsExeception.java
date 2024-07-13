package br.dev.andregurgel.gestao_vagas.exceptions;

public class CompanyAlreadyExistsExeception extends RuntimeException {
    public CompanyAlreadyExistsExeception() {
        super("Usuário ou email já existem.");
    }
}

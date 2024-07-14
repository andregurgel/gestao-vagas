package br.dev.andregurgel.gestao_vagas.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super("Entidade não encontrada ou não existe.");
    }
}

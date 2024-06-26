package br.dev.andregurgel.gestao_vagas.modules.candidate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.dev.andregurgel.gestao_vagas.exceptions.CandidadeAlreadyExistsExeception;
import br.dev.andregurgel.gestao_vagas.modules.candidate.CandidateEntity;
import br.dev.andregurgel.gestao_vagas.modules.candidate.CandidateRepository;

@Service
public class CandidateService {
    @Autowired
    private CandidateRepository candidateRepository;
    
    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent(candidate -> {
            throw new CandidadeAlreadyExistsExeception();
        });
        return this.candidateRepository.save(candidateEntity);
    }
}

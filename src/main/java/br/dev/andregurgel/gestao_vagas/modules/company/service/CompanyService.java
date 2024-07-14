package br.dev.andregurgel.gestao_vagas.modules.company.service;

import br.dev.andregurgel.gestao_vagas.exceptions.CompanyAlreadyExistsExeception;
import br.dev.andregurgel.gestao_vagas.exceptions.EntityNotFoundException;
import br.dev.andregurgel.gestao_vagas.modules.company.entities.CompanyEntity;
import br.dev.andregurgel.gestao_vagas.modules.company.repositories.CompanyRepository;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity findById(UUID id) {
        return this.companyRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent(company -> {
                    throw new CompanyAlreadyExistsExeception();
                });
        return this.companyRepository.save(companyEntity);
    }
}

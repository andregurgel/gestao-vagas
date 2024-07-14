package br.dev.andregurgel.gestao_vagas.modules.company.service;

import br.dev.andregurgel.gestao_vagas.exceptions.EntityNotFoundException;
import br.dev.andregurgel.gestao_vagas.modules.company.entities.JobEntity;
import br.dev.andregurgel.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyService companyService;

    public JobEntity execute(JobEntity jobEntity) {
        companyService.findById(jobEntity.getCompanyId());
        return this.jobRepository.save(jobEntity);
    }
}

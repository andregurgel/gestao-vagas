package br.dev.andregurgel.gestao_vagas.modules.company.controllers;

import br.dev.andregurgel.gestao_vagas.modules.company.entities.JobEntity;
import br.dev.andregurgel.gestao_vagas.modules.company.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity jobEntity) {
        try {
            return ResponseEntity.ok(this.jobService.execute(jobEntity));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

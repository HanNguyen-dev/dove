package com.dove.forage.controller;

import com.dove.forage.domain.interfaces.ICompanyService;
import com.dove.forage.domain.models.CompanyRequest;
import com.dove.forage.repository.entity.CompanyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/companies")
public class CompanyController {

    Logger logger = LoggerFactory.getLogger(CompanyController.class);

    private final ICompanyService service;

    public CompanyController(ICompanyService service) {
        this.service = service;
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyEntity> getCompany(@PathVariable Integer companyId) {
        logger.info(companyId.toString());
        try {
            return ResponseEntity.ok()
                                 .body(service.getCompany(companyId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping()
    public Iterable<CompanyEntity> getCompanies() {
        return service.getCompanies();
    }

    @PostMapping()
    public ResponseEntity<String> createCompany(@RequestBody CompanyRequest companyRequest) {
        if (service.createCompany(companyRequest)) {
            return ResponseEntity.status(HttpStatus.OK)
                                 .body("Your company was successfully saved");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Sorry, we weren't about to process your request");
        }
    }
}

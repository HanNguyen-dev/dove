package com.dove.forage.service;

import com.dove.forage.domain.interfaces.ICompanyService;
import com.dove.forage.domain.models.CompanyRequest;
import com.dove.forage.repository.CompanyRepository;
import com.dove.forage.repository.entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository repository;

    public Iterable<CompanyEntity> getCompanies() {
        return repository.findAll();
    }

    public CompanyEntity getCompany(Integer companyId) {
        return repository.findById(companyId).orElseThrow();
    }

    public boolean createCompany(CompanyRequest companyRequest) {
        try {
            repository.save(convertCompany(companyRequest));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private CompanyEntity convertCompany(CompanyRequest companyRequest) {
        CompanyEntity entity = new CompanyEntity();
        entity.setName(companyRequest.getName());
        entity.setHeadquarter(companyRequest.getHeadquarter());
        entity.setIndustryId(companyRequest.getIndustryId());

        return entity;
    }

}

package com.dove.forage.service;

import com.dove.forage.domain.interfaces.ICompanyService;
import com.dove.forage.domain.models.Company;
import com.dove.forage.domain.models.CompanyRequest;
import com.dove.forage.repository.CompanyRepository;
import com.dove.forage.repository.IndustryRepository;
import com.dove.forage.repository.entity.CompanyEntity;
import com.dove.forage.repository.entity.IndustryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private CompanyRepository repository;

    @Autowired
    private IndustryRepository industryRepo;

    public Iterable<Company> getCompanies() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::convertCompany)
                .toList();
    }

    public CompanyEntity getCompany(Integer companyId) {
        return repository.findById(companyId).orElseThrow();
    }

    public boolean createCompany(CompanyRequest companyRequest) {
        try {
            IndustryEntity industry = industryRepo
                    .findById(companyRequest.getIndustryId())
                    .orElseThrow();
            repository.save(convertCompany(companyRequest, industry));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private CompanyEntity convertCompany(CompanyRequest companyRequest, IndustryEntity industry) {
        CompanyEntity entity = new CompanyEntity();
        entity.setName(companyRequest.getName());
        entity.setHeadquarter(companyRequest.getHeadquarter());
        entity.setIndustry(industry);
        return entity;
    }

    private Company convertCompany(CompanyEntity entity) {
        return Company
                .builder()
                .name(entity.getName())
                .headquarter(entity.getHeadquarter())
                .industry(entity.getIndustry().getName())
                .build();
    }

}

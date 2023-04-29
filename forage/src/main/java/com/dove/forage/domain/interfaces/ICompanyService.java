package com.dove.forage.domain.interfaces;

import com.dove.forage.domain.models.CompanyRequest;
import com.dove.forage.repository.entity.CompanyEntity;

public interface ICompanyService {

    Iterable<CompanyEntity> getCompanies();

    CompanyEntity getCompany(Integer companyId);

    boolean createCompany(CompanyRequest companyRequest);

}

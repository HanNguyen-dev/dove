package com.dove.forage.domain.interfaces;

import com.dove.forage.domain.models.Company;
import com.dove.forage.domain.models.CompanyRequest;
import com.dove.forage.repository.entity.CompanyEntity;

public interface ICompanyService {

    Iterable<Company> getCompanies();

    CompanyEntity getCompany(Integer companyId);

    boolean createCompany(CompanyRequest companyRequest);

}

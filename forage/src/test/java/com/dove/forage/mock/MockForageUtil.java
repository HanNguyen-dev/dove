package com.dove.forage.mock;

import com.dove.forage.repository.entity.CompanyEntity;

import java.util.ArrayList;
import java.util.List;

public class MockForageUtil {

    public static Iterable<CompanyEntity> generateCompanies() {
        List<CompanyEntity> results = new ArrayList<>();

        results.add(generateCompany());

        return results;
    }

    public static CompanyEntity generateCompany() {
        CompanyEntity entity = new CompanyEntity();

        entity.setIndustryId(1);
        entity.setCompanyId(2);
        entity.setHeadquarter("Atlanta, GA");
        entity.setName("Magnum Inc.");

        return entity;
    }
}

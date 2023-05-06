package com.dove.forage.service;

import com.dove.forage.mock.MockForageUtil;
import com.dove.forage.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CompanyServiceTests {

    @InjectMocks
    CompanyService companyService;

    @Mock
    private CompanyRepository repository;

    @Test
    public void getCompaniesFromRepositoryIsValid() {
        when(repository.findAll()).thenReturn(MockForageUtil.generateCompanies());

        final var companies = companyService.getCompanies();
        companies.forEach(company -> {
            assertEquals(company.getName(), "Magnum Inc.");
        });
    }
}

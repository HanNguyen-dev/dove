package com.dove.forage.controller;

import com.dove.forage.domain.interfaces.ICompanyService;
import com.dove.forage.mock.MockForageUtil;
import com.dove.forage.repository.entity.CompanyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompanyController.class)
public class CompanyControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICompanyService companyService;

    @Test
    public void getCompaniesIsValid() throws Exception {
        Iterable<CompanyEntity> mockEntities = MockForageUtil.generateCompanies();

        when(companyService.getCompanies()).thenReturn(mockEntities);

        mockMvc.perform(get("/companies").accept(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$[0].headquarter").value("Atlanta, GA"));

    }

}

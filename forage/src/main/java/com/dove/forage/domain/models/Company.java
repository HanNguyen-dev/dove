package com.dove.forage.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    private Integer companyId;

    private String name;

    private String headquarter;

    private String industry;
}

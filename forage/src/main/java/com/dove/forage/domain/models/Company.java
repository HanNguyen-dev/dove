package com.dove.forage.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Company {

    private String name;

    private String headquarter;

    private String industry;
}

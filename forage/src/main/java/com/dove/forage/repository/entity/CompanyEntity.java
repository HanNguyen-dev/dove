package com.dove.forage.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    private String name;

    private String headquarter;

//    private Integer industryId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "industry_id", referencedColumnName = "industryId")
    private IndustryEntity industry;

}

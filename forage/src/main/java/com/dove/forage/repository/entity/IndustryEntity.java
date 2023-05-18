package com.dove.forage.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity()
@Table(name = "industry")
public class IndustryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer industryId;

    private String name;

}

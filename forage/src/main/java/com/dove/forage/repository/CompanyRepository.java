package com.dove.forage.repository;

import org.springframework.data.repository.CrudRepository;
import com.dove.forage.repository.entity.CompanyEntity;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Integer> {

}

package com.dove.forage.repository;

import com.dove.forage.repository.entity.JobEntity;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<JobEntity, Integer> {

}

package com.dove.forage.repository;

import com.dove.forage.repository.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Integer> {

}

package com.dove.forage.service;

import com.dove.forage.domain.interfaces.IJobService;
import com.dove.forage.domain.models.Job;
import com.dove.forage.domain.models.JobRequest;
import com.dove.forage.repository.CompanyRepository;
import com.dove.forage.repository.JobRepository;
import com.dove.forage.repository.entity.CompanyEntity;
import com.dove.forage.repository.entity.JobEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JobService implements IJobService {
    @Autowired
    private JobRepository repository;

    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Job> getJobs() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::convertJob)
                .collect(Collectors.toList());
    }

    public Integer createJob(JobRequest job) {
        Optional<CompanyEntity> companyEntityRetrieved = companyRepository.findById(job.getCompanyId());

        if (companyEntityRetrieved.isPresent()) {
            CompanyEntity companyEntity = companyEntityRetrieved.get();
            JobEntity jobEntity = convertJob(job, companyEntity);
            JobEntity result = repository.save(jobEntity);
            return result.getJobId();
        }
        return null;
    }

    private JobEntity convertJob(JobRequest jobRequest, CompanyEntity companyEntity) {
        JobEntity entity = new JobEntity();

        entity.setTitle(jobRequest.getTitle());
        entity.setFrontend(jobRequest.getFrontend());
        entity.setBackend(jobRequest.getBackend());
        entity.setStoreDb(jobRequest.getStoreDb());
        entity.setCloud(jobRequest.getCloud());
        entity.setLanguages(jobRequest.getLanguages());
        entity.setExperience(jobRequest.getExperience());
        entity.setUrl(jobRequest.getUrl());
        entity.setCompany(companyEntity);
        return entity;
    }

    private Job convertJob(JobEntity jobEntity) {
        return Job
                .builder()
                .jobId(jobEntity.getJobId())
                .title(jobEntity.getTitle())
                .frontend(jobEntity.getFrontend())
                .backend(jobEntity.getBackend())
                .storeDb(jobEntity.getStoreDb())
                .cloud(jobEntity.getCloud())
                .languages(jobEntity.getLanguages())
                .experience(jobEntity.getExperience())
                .url(jobEntity.getUrl())
                .companyName(jobEntity.getCompany().getName())
                .build();
    }

}

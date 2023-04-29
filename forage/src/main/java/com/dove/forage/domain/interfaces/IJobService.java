package com.dove.forage.domain.interfaces;

import com.dove.forage.domain.models.Job;
import com.dove.forage.domain.models.JobRequest;

public interface IJobService {

    Iterable<Job> getJobs();

    Integer createJob(JobRequest jobRequest);

}

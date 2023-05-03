package com.dove.forage.controller;

import com.dove.forage.domain.interfaces.IJobService;
import com.dove.forage.domain.models.Job;
import com.dove.forage.domain.models.JobRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/jobs")
public class JobController {

    private final IJobService service;

    public JobController(IJobService service) {
        this.service = service;
    }

    @GetMapping()
    public Iterable<Job> getJobs() {
        return service.getJobs();
    }

    @PostMapping()
    public ResponseEntity<String> createJob(@RequestBody JobRequest jobRequest) {
        Integer jobId = service.createJob(jobRequest);

        if (jobId != null) {
            String location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(jobId)
                    .toUriString();
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .header(HttpHeaders.LOCATION, location)
                                 .body("Your request has been completed");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Sorry, we were unable to process your request");
        }
    }

    @PutMapping()
    public ResponseEntity<String> updateJob(@RequestBody JobRequest jobRequest) {
        Integer jobId = service.updateJob(jobRequest);

        if (jobId != null) {
            String location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(jobId)
                    .toUriString();
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                                 .header(HttpHeaders.CONTENT_LOCATION, location)
                                 .build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Sorry, we were unable to process your request");
        }
    }

}

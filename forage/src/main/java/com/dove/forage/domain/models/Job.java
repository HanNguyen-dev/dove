package com.dove.forage.domain.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Job {

    private Integer jobId;

    private String title;

    private String frontend;

    private String backend;

    private String storeDb;

    private String cloud;

    private String languages;

    private String experience;

    private String companyName;

    private String url;

}

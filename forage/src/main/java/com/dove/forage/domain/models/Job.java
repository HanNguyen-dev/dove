package com.dove.forage.domain.models;

import lombok.Builder;
import lombok.Data;
import java.sql.Date;

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

    private Date appliedDate;

    private String status;

    private String companyName;

    private String url;

}

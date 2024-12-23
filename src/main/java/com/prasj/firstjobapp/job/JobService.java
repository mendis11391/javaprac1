package com.prasj.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    List<Job> createJob(Job job);

    Job getJobById(Long id);

    boolean deleteById(Long id);

    Boolean updateJobId(Long id, Job job);
}

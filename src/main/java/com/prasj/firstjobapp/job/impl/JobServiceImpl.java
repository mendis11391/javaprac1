package com.prasj.firstjobapp.job.impl;

import com.prasj.firstjobapp.job.Job;
import com.prasj.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    private Long nextVal = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public List<Job> createJob(Job job) {
        job.setId(nextVal++);
        jobs.add(job);
        return jobs;
    }

    @Override
    public Job getJobById(Long id) {
        for (Job jobm:
                jobs) {
            if(jobm.getId()== id) {
                return jobm;
            }
            }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while(iterator.hasNext()) {
            Job job = iterator.next();
            if(job.getId() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateJobId(Long id, Job updatedJob) {
        for(Job job: jobs) {
            if(job.getId() == id) {
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
        }

}

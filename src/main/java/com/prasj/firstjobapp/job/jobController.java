package com.prasj.firstjobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class jobController {
    private JobService jobService;

    public jobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping
    public List<Job> createJob(@RequestBody Job job) {
        List<Job> allJobs = jobService.createJob(job);
        return allJobs;
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        return job;
    }

    @DeleteMapping("/{id}")
    public String deleteJobById(@PathVariable Long id) {
        boolean deleted = jobService.deleteById(id);
        return "Deleted";
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        Boolean updated = jobService.updateJobId(id, updatedJob);
        if(updated) {
            return "Updated";
        }
        return "Error";
    }
}

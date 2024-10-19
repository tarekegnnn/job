package com.organization.job.controll;

import com.organization.job.model.JobModel;
import com.organization.job.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jobs")
public class JobControll {

    private final JobService jobService;

    @Autowired
    public JobControll(JobService jobService) {
        this.jobService = jobService;
    }

    // Get all jobs
    @GetMapping
    public List<JobModel> getAllJobs() {
        return jobService.getAllJobs();
    }

    // Get a job by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobModel> getJobById(@PathVariable Long id) {
        Optional<JobModel> job = jobService.getJobById(id);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new job
    @PostMapping
    public ResponseEntity<JobModel> createJob(@RequestBody JobModel jobModel) {
        JobModel createdJob = jobService.createJob(jobModel);
        return ResponseEntity.ok(createdJob);
    }

    // Update an existing job by ID
    @PutMapping("/{id}")
    public ResponseEntity<JobModel> updateJob(@PathVariable Long id, @RequestBody JobModel jobDetails) {
        try {
            JobModel updatedJob = jobService.updateJob(id, jobDetails);
            return ResponseEntity.ok(updatedJob);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a job by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        try {
            jobService.deleteJob(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


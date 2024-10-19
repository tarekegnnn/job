package com.organization.job.service;

import com.organization.job.model.JobModel;
import com.organization.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Method to get all jobs
    public List<JobModel> getAllJobs() {
        return jobRepository.findAll();
    }

    // Method to get a job by ID
    public Optional<JobModel> getJobById(Long jobId) {
        return jobRepository.findById(jobId);
    }

    // Method to create a new job
    public JobModel createJob(JobModel jobModel) {
        return jobRepository.save(jobModel);
    }

    // Method to update an existing job
    public JobModel updateJob(Long jobId, JobModel jobDetails) {
        return jobRepository.findById(jobId)
                .map(existingJob -> {
                    existingJob.setDepartmentId(jobDetails.getDepartmentId());
                    existingJob.setJobName(jobDetails.getJobName());
                    existingJob.setDescription(jobDetails.getDescription());
                    return jobRepository.save(existingJob);
                }).orElseThrow(() -> new RuntimeException("Job not found with id " + jobId));
    }

    // Method to delete a job by ID
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}


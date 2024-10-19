package com.organization.job.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class JobModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "job_name")
    private String jobName;

    @Column(name = "description")
    private String description;

    // Define the many-to-one relationship with JobGradeModel
    @ManyToOne
    @JoinColumn(name = "job_grade_id", nullable = false)
    private JobGradeModel jobGrade;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobGradeModel getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(JobGradeModel jobGrade) {
        this.jobGrade = jobGrade;
    }

    // Default constructor
    public JobModel() {
        // No-argument constructor required by JPA
    }
}

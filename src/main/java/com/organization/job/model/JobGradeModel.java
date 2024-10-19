package com.organization.job.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "job_grades")
public class JobGradeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobGradeId;

    @Column(name = "job_grade_name", nullable = false)
    private String jobGradeName;

    @Column(name = "description")
    private String description;

    public void setJobGradeName(String jobGradeName) {
        this.jobGradeName = jobGradeName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // One-to-many relationship with PayGradeModel
    @OneToMany(mappedBy = "jobGrade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PayGradeModel> payGrades;

    // Default constructor
    public JobGradeModel() {
        // No-argument constructor required by JPA
    }

    public String getJobGradeName() {

        return "";
    }

    public String getDescription() {

        return "";
    }
}

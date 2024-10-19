package com.organization.job.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "pay_grades")
public class PayGradeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_grade_id", nullable = false)
    @NotNull(message = "Job grade ID cannot be null")
    private Long jobGradeId;

    @Column(name = "salary_step", nullable = false)
    @NotNull(message = "Salary step cannot be null")
    @Min(value = 1, message = "Salary step must be at least 1")
    private Integer salaryStep;

    @Column(name = "salary", nullable = false)
    @NotNull(message = "Salary cannot be null")
    @DecimalMin(value = "0.0", message = "Salary must be greater than or equal to 0")
    private Double salary;

    public void setJobGradeId(@NotNull(message = "Job grade ID cannot be null") Long jobGradeId) {
        this.jobGradeId = jobGradeId;
    }

    public void setSalaryStep(@NotNull(message = "Salary step cannot be null") @Min(value = 1,
            message = "Salary step must be at least 1") Integer salaryStep) {
        this.salaryStep = salaryStep;
    }

    public void setSalary(@NotNull(message = "Salary cannot be null") @DecimalMin(value = "0.0",
            message = "Salary must be greater than or equal to 0") Double salary) {
        this.salary = salary;
    }

    // Many-to-one relationship with JobGradeModel
    @ManyToOne
    @JoinColumn(name = "job_grade_id", insertable = false, updatable = false)
    private JobGradeModel jobGrade;

    // Default constructor
    public PayGradeModel() {
        // No-argument constructor required by JPA
    }

    public @NotNull(message = "Job grade ID cannot be null") Long getJobGradeId() {

        return 0L;
    }

    public @NotNull(message = "Salary step cannot be null") @Min(value = 1,
            message = "Salary step must be at least 1") Integer getSalaryStep() {

        return 0;
    }

    public @NotNull(message = "Salary cannot be null") @DecimalMin(value = "0.0",
            message = "Salary must be greater than or equal to 0") Double getSalary() {

        return 0.0;
    }
}

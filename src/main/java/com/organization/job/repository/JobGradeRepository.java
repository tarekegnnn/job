package com.organization.job.repository;

import com.organization.job.model.JobGradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobGradeRepository extends JpaRepository<JobGradeModel, Long> {
}


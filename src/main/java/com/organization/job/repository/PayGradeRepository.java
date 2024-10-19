package com.organization.job.repository;

import com.organization.job.model.PayGradeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayGradeRepository extends JpaRepository<PayGradeModel, Long> {
}


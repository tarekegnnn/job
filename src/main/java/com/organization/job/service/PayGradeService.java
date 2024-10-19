package com.organization.job.service;

import com.organization.job.model.PayGradeModel;
import com.organization.job.repository.PayGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayGradeService {

    private final PayGradeRepository payGradeRepository;

    @Autowired
    public PayGradeService(PayGradeRepository payGradeRepository) {
        this.payGradeRepository = payGradeRepository;
    }

    // Method to get all pay grades
    public List<PayGradeModel> getAllPayGrades() {
        return payGradeRepository.findAll();
    }

    // Method to get a pay grade by ID
    public Optional<PayGradeModel> getPayGradeById(Long id) {
        return payGradeRepository.findById(id);
    }

    // Method to create a new pay grade
    public PayGradeModel createPayGrade(PayGradeModel payGradeModel) {
        return payGradeRepository.save(payGradeModel);
    }

    // Method to update an existing pay grade
    public PayGradeModel updatePayGrade(Long id, PayGradeModel payGradeDetails) {
        return payGradeRepository.findById(id)
                .map(existingPayGrade -> {
                    existingPayGrade.setJobGradeId(payGradeDetails.getJobGradeId());
                    existingPayGrade.setSalaryStep(payGradeDetails.getSalaryStep());
                    existingPayGrade.setSalary(payGradeDetails.getSalary());
                    return payGradeRepository.save(existingPayGrade);
                }).orElseThrow(() -> new RuntimeException("Pay grade not found with id " + id));
    }

    // Method to delete a pay grade by ID
    public void deletePayGrade(Long id) {
        payGradeRepository.deleteById(id);
    }
}


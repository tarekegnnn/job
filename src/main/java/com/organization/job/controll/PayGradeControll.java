package com.organization.job.controll;

import com.organization.job.model.PayGradeModel;
import com.organization.job.service.PayGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pay-grades")
public class PayGradeControll {

    private final PayGradeService payGradeService;

    @Autowired
    public PayGradeControll(PayGradeService payGradeService) {
        this.payGradeService = payGradeService;
    }

    // Get all pay grades
    @GetMapping
    public List<PayGradeModel> getAllPayGrades() {
        return payGradeService.getAllPayGrades();
    }

    // Get a pay grade by ID
    @GetMapping("/{id}")
    public ResponseEntity<PayGradeModel> getPayGradeById(@PathVariable Long id) {
        Optional<PayGradeModel> payGrade = payGradeService.getPayGradeById(id);
        return payGrade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new pay grade
    @PostMapping
    public ResponseEntity<PayGradeModel> createPayGrade(@RequestBody PayGradeModel payGradeModel) {
        PayGradeModel createdPayGrade = payGradeService.createPayGrade(payGradeModel);
        return ResponseEntity.ok(createdPayGrade);
    }

    // Update a pay grade by ID
    @PutMapping("/{id}")
    public ResponseEntity<PayGradeModel> updatePayGrade(@PathVariable Long id, @RequestBody PayGradeModel payGradeDetails) {
        try {
            PayGradeModel updatedPayGrade = payGradeService.updatePayGrade(id, payGradeDetails);
            return ResponseEntity.ok(updatedPayGrade);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a pay grade by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayGrade(@PathVariable Long id) {
        try {
            payGradeService.deletePayGrade(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}


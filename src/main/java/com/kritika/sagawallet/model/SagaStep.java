package com.kritika.sagawallet.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "saga_step")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SagaStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "saga_instance_id", nullable = false)
    private Long sagaInstanceId;

    @Column(name = "step_name", nullable = false)
    private String stepName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StepStatus status;

    @Column(name = "step_data", columnDefinition = "json")
    private String stepData;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = StepStatus.PENDING;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsRunning() {
        this.status = StepStatus.RUNNING;
    }

    public void markAsCompleted() {
        this.status = StepStatus.COMPLETED;
    }

    public void markAsFailed() {
        this.status = StepStatus.FAILED;
    }

    public void markAsCompensating() {
        this.status = StepStatus.COMPENSATING;
    }

    public void markAsCompensated() {
        this.status = StepStatus.COMPENSATED;
    }
}

package com.kritika.sagawallet.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "saga_instance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SagaInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SagaStatus status;

    @Column(columnDefinition = "json")
    private String context;

    @Column(name = "current_step")
    private String currentStep;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = SagaStatus.STARTED;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void markAsRunning() {
        this.status = SagaStatus.RUNNING;
    }

    public void markAsFailed() {
        this.status = SagaStatus.FAILED;
    }

    public void markAsCompensated() {
        this.status = SagaStatus.COMPENSATED;
    }

    public void markAsCompleted() {
        this.status = SagaStatus.COMPLETED;
    }

    public void markAsCompensating() {
        this.status = SagaStatus.COMPENSATING;
    }
}

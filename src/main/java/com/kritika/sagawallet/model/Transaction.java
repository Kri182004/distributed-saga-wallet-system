package com.kritika.sagawallet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_wallet_id", nullable = false)
    private Long fromWalletId;

    @Column(name = "to_wallet_id", nullable = false)
    private Long toWalletId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType type;

    @Column(name = "description")
    private String description;

    @Column(name = "saga_instance_id")
    private Long sagaInstanceId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        if (status == null) {
            status = TransactionStatus.PENDING;
        }
        if (type == null) {
            type = TransactionType.TRANSFER;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

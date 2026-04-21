package com.kritika.sagawallet.model;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "outbox")
@Getter @Setter 
@Builder // <--- This must be here for .builder() to work
@NoArgsConstructor 
@AllArgsConstructor
public class OutboxEvent {
    @Id
    // Note: No @GeneratedValue here, ShardingSphere handles ID generation
    private Long id; 
    
    private Long userId; // The sharding key
    private String aggregateType;
    private String aggregateId;
    private String type;
    
    @Column(columnDefinition = "TEXT")
    private String payload;
    
    private String status;
    private LocalDateTime createdAt;
}
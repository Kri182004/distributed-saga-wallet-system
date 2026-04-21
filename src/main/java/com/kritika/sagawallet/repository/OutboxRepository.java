package com.kritika.sagawallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kritika.sagawallet.model.OutboxEvent;

public interface OutboxRepository extends JpaRepository<OutboxEvent, Long> {

    List<OutboxEvent> findByStatus(String status);
    List<OutboxEvent> findByUserIdAndStatus(Long userId, String status);
}

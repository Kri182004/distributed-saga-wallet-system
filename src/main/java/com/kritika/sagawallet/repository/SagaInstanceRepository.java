package com.kritika.sagawallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kritika.sagawallet.model.SagaInstance;

@Repository
public interface SagaInstanceRepository extends JpaRepository<SagaInstance, Long> {
}

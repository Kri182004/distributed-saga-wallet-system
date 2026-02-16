package com.kritika.Sharded_Saga_Wallet_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kritika.Sharded_Saga_Wallet_System.model.SagaInstance;

@Repository
public interface SagaInstanceRepository extends JpaRepository<SagaInstance, Long> {
}

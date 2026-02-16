package com.kritika.Sharded_Saga_Wallet_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kritika.Sharded_Saga_Wallet_System.model.SagaStep;
import com.kritika.Sharded_Saga_Wallet_System.model.StepStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface SagaStepRepository extends JpaRepository<SagaStep, Long> {


    Optional<SagaStep> findBySagaInstanceIdAndStepNameAndStatus(Long sagaInstanceId, String stepName, StepStatus status);

    List<SagaStep> findCompletedStepsBySagaInstanceId(Long sagaInstanceId);
}

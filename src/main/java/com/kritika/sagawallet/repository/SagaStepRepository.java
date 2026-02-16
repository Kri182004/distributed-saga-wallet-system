package com.kritika.sagawallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kritika.sagawallet.model.SagaStep;
import com.kritika.sagawallet.model.StepStatus;

import java.util.List;
import java.util.Optional;

@Repository
public interface SagaStepRepository extends JpaRepository<SagaStep, Long> {


    Optional<SagaStep> findBySagaInstanceIdAndStepNameAndStatus(Long sagaInstanceId, String stepName, StepStatus status);

    List<SagaStep> findCompletedStepsBySagaInstanceId(Long sagaInstanceId);
}

package com.kritika.sagawallet.service.saga.steps;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.kritika.sagawallet.service.saga.SagaStepInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SagaStepFactory {

    private final List<SagaStepInterface> sagaSteps;

    public static final List<SagaStepType> TransferMoneySagaSteps = List.of(
            SagaStepType.DEBIT_SOURCE_WALLET_STEP,
            SagaStepType.CREDIT_DESTINATION_WALLET_STEP,
            SagaStepType.UPDATE_TRANSACTION_STATUS_STEP
    );

    public SagaStepInterface getStepName(String stepName) {

        Map<String, SagaStepInterface> stepMap = new HashMap<>();

        for (SagaStepInterface step : sagaSteps) {
            stepMap.put(step.getStepName(), step);
        }

        return stepMap.get(stepName);
    }
}

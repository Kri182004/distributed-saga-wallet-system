package com.kritika.Sharded_Saga_Wallet_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kritika.Sharded_Saga_Wallet_System.service.saga.SagaStepInterface;
import com.kritika.Sharded_Saga_Wallet_System.service.saga.steps.CreditDestinationWalletStep;
import com.kritika.Sharded_Saga_Wallet_System.service.saga.steps.DebitSourceWalletStep;
import com.kritika.Sharded_Saga_Wallet_System.service.saga.steps.SagaStepType;
import com.kritika.Sharded_Saga_Wallet_System.service.saga.steps.UpdateTransactionStatus;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SagaConfiguration {

    @Bean
    public Map<String, SagaStepInterface> sagaStepMap(
        DebitSourceWalletStep debitSourceWalletStep,
        CreditDestinationWalletStep creditDestinationWalletStep,
        UpdateTransactionStatus updateTransactionStatus
    ) {
        Map<String, SagaStepInterface> map = new HashMap<>();
        map.put(SagaStepType.DEBIT_SOURCE_WALLET_STEP.toString(), debitSourceWalletStep);
        map.put(SagaStepType.CREDIT_DESTINATION_WALLET_STEP.toString(), creditDestinationWalletStep);
        map.put(SagaStepType.UPDATE_TRANSACTION_STATUS_STEP.toString(), updateTransactionStatus);
        return map;
    }
    
}

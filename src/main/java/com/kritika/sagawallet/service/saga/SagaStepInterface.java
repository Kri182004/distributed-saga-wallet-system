package com.kritika.sagawallet.service.saga;

public interface SagaStepInterface {
    boolean execute(SagaContext sagaContext);

    boolean compensate(SagaContext sagaContext);

    String getStepName();
}

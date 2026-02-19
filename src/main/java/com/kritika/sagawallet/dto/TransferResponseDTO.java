package com.kritika.sagawallet.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferResponseDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long sagaInstanceId;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long transactionId;
    private String status;
    private String message;
}

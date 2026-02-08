package com.friedchicken.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResponseDto {
    private String statusCode;
    private String statusMsg;
}

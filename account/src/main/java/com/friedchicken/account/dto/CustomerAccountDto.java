package com.friedchicken.account.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerAccountDto {
    private String name;
    private String email;
    private String mobileNumber;
    @NotNull(message = "Account Number can not be null.")
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}

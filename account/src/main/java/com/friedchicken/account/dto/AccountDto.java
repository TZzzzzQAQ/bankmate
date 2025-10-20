package com.friedchicken.account.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    @NotEmpty(message = "Account Number can not be a null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;
    @NotEmpty(message = "Account Type can not be a null or empty.")
    private String accountType;
    @NotEmpty(message = "Branch Address can not be a null or empty")
    private String branchAddress;
}

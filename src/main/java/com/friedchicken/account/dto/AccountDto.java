package com.friedchicken.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountDto {
    @NotEmpty(message = "Account Number can not be a null or empty.")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    @Schema(
            description = "Account Number of BankMate account", example = "3454433243"
    )
    private Long accountNumber;

    @NotEmpty(message = "Account Type can not be a null or empty.")
    @Schema(
            description = "Account type of BankMate account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "Branch Address can not be a null or empty")
    @Schema(
            description = "BankMate branch address", example = "123 NewYork"
    )
    private String branchAddress;
}

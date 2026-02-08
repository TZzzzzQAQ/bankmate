package com.friedchicken.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Schema(
        name = "Customer with Account information",
        description = "Schema to create new Customer with Account information"
)
public class CustomerAccountDto {

    @Schema(
            description = "Name of the customer", example = "Jack Tan"
    )
    @NotEmpty(message = "Name can not be a null or empty")
    @Size(min = 2, max = 30, message = "The length of the customer name should be between 2 and 30")
    private String name;

    @Schema(
            description = "Email address of the customer", example = "tzzzqaq@gmail.com"
    )
    @NotEmpty(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Mobile Number of the customer", example = "9345432123"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

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

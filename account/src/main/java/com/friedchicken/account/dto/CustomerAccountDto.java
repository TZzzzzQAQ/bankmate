package com.friedchicken.account.dto;

import lombok.Data;

@Data
public class CustomerAccountDto  {
    private String name;
    private String email;
    private String mobileNumber;
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}

package com.friedchicken.account.service;

import com.friedchicken.account.dto.CustomerAccountDto;
import com.friedchicken.account.dto.CustomerDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountService {
    /**
     * @param customerDto - Customer Data Transfer Object
     * @author TZzzQAQ
     * @date 10/10/2025
     **/
    void createAccount(@RequestBody CustomerDto customerDto);


    /**
     * @param mobileNumber - Mobile Number of the customer
     * @return Accounts Details based on the given mobile number
     * @author TZzzQAQ
     * @date 12/10/2025
     **/
    CustomerAccountDto fetchAccountByMobileNumber(String mobileNumber);

    /**
     * @param customerAccountDto - Customer and Account information
     * @author TZzzQAQ
     * @date 13/10/2025
     **/
    void updateAccount(CustomerAccountDto customerAccountDto);

    /**
     * @param mobileNumber - Mobile Number of the customer 
     * @author TZzzQAQ
     * @date 17/10/2025
     **/
    void deleteAccount(String mobileNumber);
}

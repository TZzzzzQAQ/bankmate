package com.friedchicken.account.service;

import com.friedchicken.account.dto.CustomerDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAccountService {
    /**
     * @param customerDto - Customer Data Transfer Object
     * @author TZzzQAQ
     * @date 10/10/2025
     **/
    void createAccount(@RequestBody CustomerDto customerDto);
}

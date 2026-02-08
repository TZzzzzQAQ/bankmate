package com.friedchicken.account.factory;

import com.friedchicken.account.constants.AccountConstants;
import com.friedchicken.account.entity.Account;
import com.friedchicken.account.entity.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class AccountFactory {

    /**
     * @param customer - Customer Object
     * @return New account details
     * @author TZzzQAQ
     * @date 11/10/2025
     **/
    public Account create(Customer customer) {
        Account account = new Account();
        account.setCustomerId(customer.getCustomerId());
        account.setAccountNumber(generateRandomAccountNumber());
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("System");
        return account;
    }

    private long generateRandomAccountNumber() {
        return 1000000000L + new Random().nextInt(900000000);
    }
}


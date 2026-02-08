package com.friedchicken.account.service.impl;

import com.friedchicken.account.dto.AccountDto;
import com.friedchicken.account.dto.CustomerAccountDto;
import com.friedchicken.account.dto.CustomerDto;
import com.friedchicken.account.entity.Account;
import com.friedchicken.account.entity.Customer;
import com.friedchicken.account.exception.CustomerAlreadyExistsException;
import com.friedchicken.account.exception.ResourceNotFoundException;
import com.friedchicken.account.factory.AccountFactory;
import com.friedchicken.account.mapper.AccountMapper;
import com.friedchicken.account.mapper.CustomerAccountMapper;
import com.friedchicken.account.mapper.CustomerMapper;
import com.friedchicken.account.repository.AccountRepository;
import com.friedchicken.account.repository.CustomerRepository;
import com.friedchicken.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private AccountFactory accountFactory;
    private CustomerAccountMapper customerAccountMapper;

    /**
     * @param customerDto - Customer Data Transfer Object
     * @author TZzzQAQ
     * @date 10/10/2025
     **/
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with the given mobile number." + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("System");
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(accountFactory.create(savedCustomer));
    }

    /**
     * @param mobileNumber - Mobile Number of the customer
     * @return Accounts Details based on the given mobile number
     * @author TZzzQAQ
     * @date 12/10/2025
     **/
    @Override
    public CustomerAccountDto fetchAccountByMobileNumber(String mobileNumber) {
        return customerAccountMapper.findByMobile(mobileNumber);
    }

    /**
     * @param customerAccountDto - Customer and Account information
     * @author TZzzQAQ
     * @date 13/10/2025
     **/
    @Override
    public void updateAccount(CustomerAccountDto customerAccountDto) {
        AccountDto accountDto = new AccountDto(customerAccountDto.getAccountNumber(), customerAccountDto.getAccountType(), customerAccountDto.getBranchAddress());
        Account account = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(() -> new ResourceNotFoundException("Account", "Account Number", accountDto.getAccountNumber().toString()));
        AccountMapper.mapToAccount(accountDto, account);
        accountRepository.save(account);

        CustomerDto customerDto = new CustomerDto(customerAccountDto.getName(), customerAccountDto.getEmail(), customerAccountDto.getMobileNumber());
        Customer customer = customerRepository.findById(account.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Customer", "Customer Id", account.getCustomerId().toString()));
        CustomerMapper.mapToCustomer(customerDto, customer);
        customerRepository.save(customer);
    }

    /**
     * @param mobileNumber - Customer Mobild Number
     * @author TZzzQAQ
     * @date 17/10/2025
     **/
    @Override
    public void deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));
        customerRepository.deleteById(customer.getCustomerId());
        accountRepository.deleteById(customer.getCustomerId());
    }
}

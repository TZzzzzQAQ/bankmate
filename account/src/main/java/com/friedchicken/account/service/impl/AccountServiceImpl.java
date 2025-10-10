package com.friedchicken.account.service.impl;

import com.friedchicken.account.dto.CustomerDto;
import com.friedchicken.account.entity.Customer;
import com.friedchicken.account.exception.CustomerAlreadyExistsException;
import com.friedchicken.account.factory.AccountFactory;
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
}

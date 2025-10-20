package com.friedchicken.account.controller;

import com.friedchicken.account.constants.AccountConstants;
import com.friedchicken.account.dto.CustomerAccountDto;
import com.friedchicken.account.dto.CustomerDto;
import com.friedchicken.account.dto.SuccessResponseDto;
import com.friedchicken.account.service.IAccountService;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountController {
    private IAccountService iAccountService;

    @PostMapping("/create")
    public ResponseEntity<SuccessResponseDto> createAccount(@Validated @RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerAccountDto> fetchAccount(@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") @RequestParam String mobileNumber) {
        CustomerAccountDto customerAccountDto = iAccountService.fetchAccountByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.FOUND).body(customerAccountDto);
    }

    @PutMapping("/update")
    public ResponseEntity<SuccessResponseDto> updateAccount(@Validated @RequestBody CustomerAccountDto customerAccountDto) {
        iAccountService.updateAccount(customerAccountDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new SuccessResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<SuccessResponseDto> deleteAccount(@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits") @RequestParam String mobileNumber) {
        iAccountService.deleteAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new SuccessResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
    }
}

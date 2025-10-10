package com.friedchicken.account.Controller;

import com.friedchicken.account.constants.AccountConstants;
import com.friedchicken.account.dto.CustomerDto;
import com.friedchicken.account.dto.SuccessResponseDto;
import com.friedchicken.account.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountController {
    private IAccountService iAccountService;

    @PostMapping("/create")
    public ResponseEntity<SuccessResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }
}

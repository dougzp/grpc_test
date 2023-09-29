package com.douglas.cccat13.api.controller;

import com.douglas.cccat13.grpcClient.GrpcAccountService;
import com.douglas.cccat13.tos.AccountTos;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
public class AccountController {

    private final GrpcAccountService accountService;

    public AccountController(GrpcAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value ="/account")
    public ResponseEntity<String>  createAccountMessage() {


        AccountTos request = AccountTos.builder().id(UUID.randomUUID())
                .name("MyName")
                .email("myemail@email.com")
                .cpf("84029609015")
                .carPlate("AAA3230")
                .isDriver(true)
                .isPassenger(false)
                .isVerified(true)
                .verificationCode(UUID.randomUUID())
                .build();

        String result = this.accountService.createAccount(request);
        return ResponseEntity.ok(result);

    }

}

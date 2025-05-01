package com.micro.graphs.controllers;

import com.micro.graphs.nodes.Account;
import com.micro.graphs.services.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accountNumber")
    public Mono<Account> getAccount(String accountNumber) {
        return Mono.just(accountService.findByAccountNumber(accountNumber));
    }
}

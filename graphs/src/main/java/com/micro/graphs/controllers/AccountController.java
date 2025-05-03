package com.micro.graphs.controllers;

import com.micro.graphs.nodes.Account;
import com.micro.graphs.services.AccountService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/graphs")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/accountNumber/{accountNumber}")
    public Mono<Account> getAccount(@PathVariable("accountNumber") int accountNumber) {
        return Mono.just(accountService.findByAccountNumber(accountNumber));
    }

    @GetMapping("/")
    public Mono<String> getTest() {
        return Mono.just("Test");
    }
}

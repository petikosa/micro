package com.micro.graphs.services;

import com.micro.graphs.controllers.Graph;
import com.micro.graphs.controllers.Node;
import com.micro.graphs.controllers.Relationship;
import com.micro.graphs.nodes.Account;
import com.micro.graphs.repositories.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findByAccountNumber(int accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    public Graph findAllCustom() {
        return convertToGraph(accountRepository.findAll());
    }

    private Graph convertToGraph(List<Account> accounts) {
        List<Node> nodes = new ArrayList<>();
        List<Relationship> relationships = new ArrayList<>();
        long i = 0;
        for (Account a : accounts) {
            nodes.add(new Node(a.getId()));
            relationships.add(new Relationship(100 - i++, a.getId(), a.getTransaction().getId()));
        }
        Graph graph = new Graph();
        graph.nodes = nodes;
        graph.relationships = relationships;
        return graph;
    }
}

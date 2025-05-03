package com.micro.graphs.repositories;

import com.micro.graphs.nodes.Account;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AccountRepository extends Neo4jRepository<Account, Long> {

    Account findByAccountNumber(int accountNumber);
}

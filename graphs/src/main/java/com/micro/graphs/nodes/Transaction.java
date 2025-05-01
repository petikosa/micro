package com.micro.graphs.nodes;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.math.BigDecimal;
import java.time.LocalDate;

@Node
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;
    private LocalDate date;

    @Relationship(type = "BENEFITS_TO", direction = Relationship.Direction.OUTGOING)
    private Account account;
}

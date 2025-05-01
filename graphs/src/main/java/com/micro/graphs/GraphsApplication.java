package com.micro.graphs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
// @EnableNeo4jRepositories
public class GraphsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphsApplication.class, args);
	}

}

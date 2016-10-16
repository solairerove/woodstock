package com.github.solairerove.woodstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by krivitski-no on 9/13/16.
 */
@SpringBootApplication
@ComponentScan({"com.github.solairerove.woodstock"})
@EnableNeo4jRepositories("com.github.solairerove.woodstock.repository")
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

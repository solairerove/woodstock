package com.github.solairerove.woodstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by krivitski-no on 9/13/16.
 */
@SpringBootApplication
@EnableNeo4jRepositories({"com.github.solairerove.woodstock.repository", "BOOT-INF.classes.com.github.solairerove.woodstock.repository"})
@EntityScan({"com.github.solairerove.woodstock.domain", "BOOT-INF.classes.com.github.solairerove.woodstock.domain"})
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

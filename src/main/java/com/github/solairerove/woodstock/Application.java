package com.github.solairerove.woodstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by krivitski-no on 9/13/16.
 */
@SpringBootApplication
@EnableMongoRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

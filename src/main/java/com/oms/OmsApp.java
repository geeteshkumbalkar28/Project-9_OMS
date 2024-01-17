package com.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.oms.repositories")
public class  OmsApp {

    public static void main(final String[] args) {

        SpringApplication.run(OmsApp.class, args);
    }

}

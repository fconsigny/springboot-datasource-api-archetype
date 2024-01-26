package com.fconsigny.springboot.datasource.api.archetype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(SpringBootConfiguration.class)
public class SpringBootApplicationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationLauncher.class, args);
    }
}
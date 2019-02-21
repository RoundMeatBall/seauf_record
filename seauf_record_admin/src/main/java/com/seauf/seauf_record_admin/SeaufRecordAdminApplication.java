package com.seauf.seauf_record_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.seauf")
public class SeaufRecordAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeaufRecordAdminApplication.class, args);
    }

}

package org.csulb.md;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DynamoDBConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamoDBConnectorApplication.class, args);
    }

}

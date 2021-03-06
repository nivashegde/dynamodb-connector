package org.csulb.md;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RedisCacheManagerApplication{	
		
    public static void main( String[] args ){
        SpringApplication.run(RedisCacheManagerApplication.class, args);
    }
    
}

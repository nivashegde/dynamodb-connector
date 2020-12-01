package org.csulb.md;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MemcachedCacheManagerApplication{	
		
    public static void main( String[] args ){
        SpringApplication.run(MemcachedCacheManagerApplication.class, args);
    }
    
}

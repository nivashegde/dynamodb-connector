package org.csulb.md.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;

@Configuration
@EnableDynamoDBRepositories(basePackages = "org.csulb.md.repo")
public class DynamoDBConfig {
	
	@Value("${amazon.dynamodb.region}")
    private String amazonDynamoDBregion;
 
    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;
 
    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;
    
    @Value("${amazon.aws.awsSessionToken}")
    private String awsSessionToken;
 
    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
    	
    	
        AmazonDynamoDB amazonDynamoDB 
          = new AmazonDynamoDBClient(amazonAWSCredentials());
        
        if (!StringUtils.isEmpty(amazonDynamoDBregion)) {
        	String endpoint = "https://dynamodb." + amazonDynamoDBregion + ".amazonaws.com";
            amazonDynamoDB.setEndpoint(endpoint);
        }
        
        return amazonDynamoDB;
    }
 
    @Bean
    public AWSCredentials amazonAWSCredentials() {
    	
    	AWSCredentials awsCredentials = null;
    	
    	if(StringUtils.isEmpty(this.awsSessionToken)) {
    		awsCredentials = new BasicAWSCredentials(this.amazonAWSAccessKey, this.amazonAWSSecretKey);
    	} else {
    		awsCredentials = new BasicSessionCredentials(this.amazonAWSAccessKey, this.amazonAWSSecretKey, this.awsSessionToken);
    	}
    	
    	return awsCredentials;
    }

}

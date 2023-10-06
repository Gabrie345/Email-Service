package com.kipper.Emailservice.application.ses;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.kipper.Emailservice.application.accessKeys.AccessKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSesConfig {
    @Bean
    public AmazonSimpleEmailService awsSesProperties() {
        return AmazonSimpleEmailServiceClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
                        AccessKey.accessKeyId,
                        AccessKey.secretKey)))
                .build();
    }
}

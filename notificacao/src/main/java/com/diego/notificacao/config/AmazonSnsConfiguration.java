package com.diego.notificacao.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AmazonSnsConfiguration {

    @Value("${aws.acessKey}")
    private String acessKey;
    @Value("${aws.secretKey}")
    private String secretKey;

//    @Bean
//    public AWSCredentials awsCredentials(){
//        return new BasicAWSCredentials(acessKey, secretKey);
//    }

//    @Bean
//    public AmazonSNS amazonSNS(){
//    }
}

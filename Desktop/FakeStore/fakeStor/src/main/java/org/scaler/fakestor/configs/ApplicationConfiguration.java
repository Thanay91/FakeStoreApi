package org.scaler.fakestor.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}

package com.ivoronline.springbott_security_events.config;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;

@Configuration
public class AuthenticationPublisher {

  @Bean
  public AuthenticationEventPublisher publish(ApplicationEventPublisher applicationEventPublisher){
    return new DefaultAuthenticationEventPublisher(applicationEventPublisher);
  }

}



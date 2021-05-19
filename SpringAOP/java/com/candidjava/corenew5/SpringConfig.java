package com.candidjava.corenew5;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class SpringConfig {
     
    @Bean
    public LogService getLogger()
    {
        return new LogServiceCommonLog();
    }
 
}
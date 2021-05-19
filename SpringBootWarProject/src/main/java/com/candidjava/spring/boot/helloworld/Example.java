package com.candidjava.spring.boot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/*@Configuration
@ComponentScan("com.candidjava.spring.boot")
@EnableAutoConfiguration*/
@SpringBootApplication
public class Example extends SpringBootServletInitializer{

   
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Example.class);
    }

}
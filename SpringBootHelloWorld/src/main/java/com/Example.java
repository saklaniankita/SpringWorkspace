package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//
/*@Configuration
@ComponentScan("*")
@EnableAutoConfiguration*/


@SpringBootApplication
public class Example 
{
    public static void main(String[] args) throws Exception 
    {
        SpringApplication.run(Example.class, args);
    }

}
package com.candidjava.spring.boot.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication // @Configuration, @EnableAutoConfiguration, @ComponentScan 
public class Example {

    //@RequestMapping(value="/", method=RequestMethod.POST)
	@GetMapping("/")
    String home() {
        return "Hello world Dev Tools !!**";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
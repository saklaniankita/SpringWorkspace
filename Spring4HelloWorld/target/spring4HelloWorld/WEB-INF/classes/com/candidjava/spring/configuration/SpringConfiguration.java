package com.candidjava.spring.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration  //Treat as the configuration file for Spring MVC-enabled applications.
@EnableWebMvc  //replace <mvc:annotation-driven> tag
@ComponentScan(basePackages="com.candidjava.spring.controller") //replaces <context:component-scan> tag
public class SpringConfiguration {
     
     
    @Bean(name="jspViewResolver")
    public ViewResolver viewResolver()
    {
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
         
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
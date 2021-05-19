package com.candidjava.corenew5;
 
import javax.annotation.PostConstruct;
 
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
@Scope(value="prototype")
@Component("logService")
public class LogServiceLog4j implements LogService{
 
     
     
    @Override
    public void logError(String s) {
        System.out.println("error log4j" + s);
    }
 
    @Override
    public void logDeb(String s) {
        System.out.println("deb log4j" + s);
         
    }
 
}
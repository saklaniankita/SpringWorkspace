package com.candidjava.corebasic5;
 
import org.springframework.stereotype.Component;
 
@Component("logging")
public class CommonLoggingService implements LoggingService {
    @Override
    public void logData(String s) {
         
        System.out.println("log in CommonLoggingService" + s);
    }
}
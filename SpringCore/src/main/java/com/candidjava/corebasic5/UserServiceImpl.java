package com.candidjava.corebasic5;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
@Scope("singleton")
@Component
public class UserServiceImpl implements UserService {
 
     
    @Qualifier("logging")
    @Autowired
    private LoggingService logging;
     
    @Autowired
    private String myString;
     
    public void addUser() {
     
        System.out.println("adding user to db");
        System.out.println(myString);
        logging.logData("User.........");
         
         
        /*
         * LoggingService logging =new Log4jLoggingService();
         * logging.logData("dddddddddddd");
         */
 
    }
 
}
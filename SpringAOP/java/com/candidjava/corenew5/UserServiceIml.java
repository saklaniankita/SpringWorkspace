 package com.candidjava.corenew5;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
 
@Component
public class UserServiceIml {
     
     
    @Qualifier("logService")
    @Autowired
    LogService lService;
     
     
/*  UserServiceIml(LogService logService)
    {
        this.logService=logService;
    }
        */
    public void create()
    {
         
         
        lService.logError("  msg...");
         
    }
 
}
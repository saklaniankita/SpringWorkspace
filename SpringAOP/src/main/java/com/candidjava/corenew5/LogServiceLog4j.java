package com.candidjava.corenew5;
 
import javax.annotation.PostConstruct;
 
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
 
@Scope(value="singleton")
@Component("logservice")
public class LogServiceLog4j implements LogService{
 
    public void logError(String s) {
        System.out.println("error log4j" + s);
    }

    public void logDeb(String s) {
        System.out.println("deb log4j" + s);
         
    }
    
    public void createTest() {
    	System.out.println("Creatae.........");
    }

	public void deleteTest() {
		System.out.println("Delete in LogServiceLog4j.....");
		
	}
 
}
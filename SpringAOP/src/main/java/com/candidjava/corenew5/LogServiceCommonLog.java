package com.candidjava.corenew5;
 
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
 
@Scope("prototype")
@Component("logservice1")
public class LogServiceCommonLog implements LogService{
 
   
    public void logError(String s) {
        System.out.println("error common" + s);
         
    }
 
 
    public void logDeb(String s) {
        System.out.println("deb common" + s);
         
    }


	public void createTest() {
		System.out.println("createtest method of LogServiceCommonLog");
		
	}


	public void deleteTest() {
		System.out.println("Delete in LogServiceCommonLog......");
		
	}
 
}
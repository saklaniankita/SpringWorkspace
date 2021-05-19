package com.candidjava.corenew5;
 
import org.springframework.stereotype.Component;
 
@Component
public class LogServiceCommonLog implements LogService{
 
    @Override
    public void logError(String s) {
        System.out.println("error common" + s);
         
    }
 
    @Override
    public void logDeb(String s) {
        System.out.println("deb common" + s);
         
    }
 
}
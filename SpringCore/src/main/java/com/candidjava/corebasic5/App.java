
package com.candidjava.corebasic5;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
/**
 * Hello world!
 * 
 * If we want to replace configuration file with java code
 *
 */
 
 
@Configuration
@ComponentScan("com.candidjava")
public class App 
{
 
	//In case we want to autowire without mentioning in dispatcher servlet
	//<bean id="myString" class="java.lang.String">ankita</bean>
	//We have used 
	//@Autowired
   // private String myString; in UserServiceImpl
	
      @Bean
      public String myStringmethod()
      {
          String s1="ankita";
          return s1;
      }
       
     
    public static void main( String[] args )
    {
         //if the xml is somewhere outside the project
    //  FileSystemXmlApplicationContext context=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
       //  
     // ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
    	
         //for java based configuration
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(App.class);
         
     
        /*
         * String s1=(String)context.getBean("myString"); System.out.println(s1);
         */
         
//        UserService us1=(UserService) context.getBean("userServiceImpl");
//        UserService us2=(UserService) context.getBean("userServiceImpl");
// 
//        System.out.println(us1==us2);
//         
//        System.out.println(us1.hashCode() + "   "+us2.hashCode());
//        us1.addUser();
//        context.close();
         
    }
}
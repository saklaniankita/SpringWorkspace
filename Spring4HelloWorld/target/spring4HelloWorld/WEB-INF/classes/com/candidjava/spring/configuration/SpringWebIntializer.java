package com.candidjava.spring.configuration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
 
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
import com.candidjava.spring.configuration.SpringConfiguration;
 /**
  * This class is a replacement of web.xml
  * @author Ankita
  *
  */
public class SpringWebIntializer implements WebApplicationInitializer{
 
    public void onStartup(ServletContext container) throws ServletException {
        // TODO Auto-generated method stub
        AnnotationConfigWebApplicationContext  context=new AnnotationConfigWebApplicationContext();
        context.register( );
        context.setServletContext(container);
         
        ServletRegistration.Dynamic servlet=container.addServlet("dispatcher", new DispatcherServlet(context));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }
}
package org.haden.training.spring.springintegration.syslogingester;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Application {
	
   

    public static void main(String[] args) {
    	ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
      
    
    }

}

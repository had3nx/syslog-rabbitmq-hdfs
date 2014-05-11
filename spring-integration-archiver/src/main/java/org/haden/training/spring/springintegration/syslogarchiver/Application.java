package org.haden.training.spring.springintegration.syslogarchiver;





import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;





public class Application {


	

	public static void main(String[] args) throws Exception {
	
		
		ApplicationContext context = new ClassPathXmlApplicationContext("/application-context.xml");
		
	}

	
	
	
}

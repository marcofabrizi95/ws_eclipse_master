package it.prova.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		 
		    	Customer cust = (Customer)context.getBean("customerBean");
		    	System.out.println(cust.getPersona().getName());
	}
	    	
}

package it.prova.spring;

import it.prova.service.CheckUpService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyServiceFactory {

	private static ApplicationContext ctx;

	static {
		try {
			ctx = new ClassPathXmlApplicationContext("beans.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CheckUpService getCheckUpService() {
		return (CheckUpService) ctx.getBean("CheckUpService");
	}
	
}

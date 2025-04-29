package com.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.petclinic.practice.GreetingService;

@SpringBootApplication
public class PetclinicApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(PetclinicApplication.class, args);
		GreetingService greetingService = applicationContext.getBean(GreetingService.class);
		GreetingService greetingService2 = applicationContext.getBean(GreetingService.class); // getBean() <=> @Autowired
		System.out.println("greetingService: " + greetingService);
		System.out.println("greetingService2: " + greetingService2); // même ref que le premier <=> scope singleton
	}

}

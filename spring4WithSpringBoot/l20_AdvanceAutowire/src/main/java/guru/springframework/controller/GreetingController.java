package guru.springframework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.services.HelloWorldService;

@Controller
public class GreetingController {
	
	private HelloWorldService helloWorldService;
	private HelloWorldService helloWorldServiceGerman;
	
	private HelloWorldService helloWorldFrenchService;
	
	
	//This is injected by type
	@Autowired
	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	
	//Injected by name
	@Autowired
	@Qualifier("helloWorldServiceGerman")
	public void setHelloWorldServiceGerman(HelloWorldService helloWorldServiceGerman) {
		this.helloWorldServiceGerman = helloWorldServiceGerman;
	}

	//Injected by name
	@Autowired
	@Qualifier("french")
		public void setHelloWorldFrenchService(HelloWorldService helloWorldFrenchService) {
		this.helloWorldFrenchService = helloWorldFrenchService;
	}
	
	public String sayHello(){
		String greeting = helloWorldService.getGreeting();
		System.out.println(greeting);
		System.out.println(helloWorldFrenchService.getGreeting());
		System.out.println(helloWorldServiceGerman.getGreeting());
		return greeting;
	}

	
}

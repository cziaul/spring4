package guru.springframework.controller;

import guru.springframework.services.HelloWorldService;

//@Controller -> added <bean id="greetingController" class="guru.springframework.controller.GreetingController"></bean> in config file
public class GreetingController {
	
	private HelloWorldService helloWorldService;
	private HelloWorldService helloWorldServiceGerman;
	
	private HelloWorldService helloWorldFrenchService;
	
	
	//This is injected by type
	//@Autowired
	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}
	
	//Injected by name
	//@Autowired
	//@Qualifier("helloWorldServiceGerman")
	public void setHelloWorldServiceGerman(HelloWorldService helloWorldServiceGerman) {
		this.helloWorldServiceGerman = helloWorldServiceGerman;
	}

	//Injected by name
	//@Autowired
	//@Qualifier("french")
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

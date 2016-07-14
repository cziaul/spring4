package guru.springframework.services;

public class HelloWorldGermanImpl implements HelloWorldService {

	@Override
	public String getGreeting() {
		String helloWorld = "German Hello World";
		return helloWorld;
	}
	
}

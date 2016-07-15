package guru.springframework.services;

public class HelloWorldServiceEnglishImpl implements HelloWorldService {

	@Override
	public String getGreeting() {
		String helloWorld = "Hello World";
		return helloWorld;
	}


}

package guru.springframework.services;

public class HelloWorldFrenchImpl implements HelloWorldService{

	@Override
	public String getGreeting() {
		String helloWorld = "Franch Hello World";
		return helloWorld;
	}
	

}

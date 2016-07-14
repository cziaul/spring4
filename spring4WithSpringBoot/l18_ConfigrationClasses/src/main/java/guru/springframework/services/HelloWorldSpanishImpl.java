package guru.springframework.services;

public class HelloWorldSpanishImpl implements HelloWorldService{

	@Override
	public String getGreeting() {
		String spanish = "Hola mundo!!";
		return spanish;
	}
	

}

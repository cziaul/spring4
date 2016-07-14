package guru.springframework.services;

public class HelloWorldFactory {

	public HelloWorldService createHellowWorldService(String language) {
		
		HelloWorldService service = null;
		
		switch (language) {
			case "en":
				service = new HelloWorldServiceEnglishImpl();
				break;
			case "es":
				service = new HelloWorldSpanishImpl();
				break;
			case "de":
				service = new HelloWorldGermanImpl();
				break;
			case "fr":
				service = new HelloWorldFrenchImpl();
				break;
		default:
			new HelloWorldServiceEnglishImpl();

		}

		return service;
	}

}

package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import guru.springframework.services.HelloWorldFactory;
import guru.springframework.services.HelloWorldService;
import guru.springframework.services.HelloWorldServiceEnglishImpl;
import guru.springframework.services.HelloWorldSpanishImpl;

@Configuration
public class HelloConfig {
	
	@Bean
	public HelloWorldFactory helloWorldFactory(){
		return new HelloWorldFactory();
	}
	
	@Bean
	@Profile("english")
	public HelloWorldService helloWorldServiceEnglish(HelloWorldFactory factory){
		return factory.createHellowWorldService("en");
	}
	
	@Bean
	@Profile("spanish")
	public HelloWorldService helloWorldServiceSpanish(HelloWorldFactory factory){
		return factory.createHellowWorldService("es");
	}
	

}

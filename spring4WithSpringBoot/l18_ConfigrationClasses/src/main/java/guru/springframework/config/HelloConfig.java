package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import guru.springframework.services.HelloWorldService;
import guru.springframework.services.HelloWorldServiceEnglishImpl;
import guru.springframework.services.HelloWorldSpanishImpl;

@Configuration
public class HelloConfig {
	
	@Bean
	@Profile("english")
	public HelloWorldService helloWorldServiceEnglish(){
		return new HelloWorldServiceEnglishImpl();
	}
	
	@Bean
	@Profile("spanish")
	public HelloWorldService helloWorldServiceSpanish(){
		return new HelloWorldSpanishImpl();
	}
	

}

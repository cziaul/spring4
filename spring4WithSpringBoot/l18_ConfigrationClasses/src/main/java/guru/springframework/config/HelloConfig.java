package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import guru.springframework.services.HelloWorldService;

@Configuration
public class HelloConfig {
	
	@Bean
	@Profile("english")
	public HelloWorldService helloWorldServiceEnglish(){
		return HelloWorldServiceEnglishImpl();
	}
	
	@Bean
	@Profile("spanish")
	public HelloWorldService helloWorldServiceSpanish(){
		return HelloWorldSpanishImpl();
	}
	

}

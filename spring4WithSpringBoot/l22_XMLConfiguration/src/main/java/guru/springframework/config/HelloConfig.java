package guru.springframework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import guru.springframework.services.HelloWorldFactory;
import guru.springframework.services.HelloWorldService;

@Configuration
public class HelloConfig {
	
	//Replace with <bean id="helloWorldFactory" class="guru.springframework.services.HelloWorldFactory"></bean>
	/*@Bean
	public HelloWorldFactory helloWorldFactory(){
		return new HelloWorldFactory();
	}*/
	
	@Bean
	@Profile("english")
	@Primary
	public HelloWorldService helloWorldServiceEnglish(HelloWorldFactory factory){
		return factory.createHellowWorldService("en");
	}
	
	@Bean
	@Profile("spanish")
	@Primary
	public HelloWorldService helloWorldServiceSpanish(HelloWorldFactory factory){
		return factory.createHellowWorldService("es");
	}
	
	/*
	 * Moving helloWorldServiceFrench method to config file
	 * <bean id="french" factory-bean="helloWorldFactory" factory-method="createHellowWorldService">
		<constructor-arg value="fr"/>
	</bean>
	 
	//here with name "french" and in controller class @Qualifier("french")
	
	@Bean(name="french")
	public HelloWorldService helloWorldServiceFrench(HelloWorldFactory factory){
		return factory.createHellowWorldService("fr");
	}*/
	
	//Here we are using helloWorldServiceGerman and in controller @Qualifier("helloWorldServiceGerman")
	/*@Bean
	public HelloWorldService helloWorldServiceGerman(HelloWorldFactory factory){
		return factory.createHellowWorldService("de");
	}*/
	
	@Bean
	public HelloWorldService helloWorldServicePolish(HelloWorldFactory factory){
		return factory.createHellowWorldService("pl");
	}
	@Bean
	public HelloWorldService helloWorldServiceRussian(HelloWorldFactory factory){
		return factory.createHellowWorldService("ru");
	}
}

package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import guru.springframework.controller.GreetingController;

@SpringBootApplication
//@ComponentScan("guru.springframework") //Adding to xmlconfig file
@ImportResource("classpath:/spring/spring-config.xml")
public class DependencyinjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DependencyinjectionApplication.class, args);
		GreetingController controller = (GreetingController) ctx.getBean("greetingController");
		controller.sayHello();
		
	}
}

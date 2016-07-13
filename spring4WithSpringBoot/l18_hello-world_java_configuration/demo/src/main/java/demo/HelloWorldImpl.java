package demo;

import org.springframework.stereotype.Component;

/**
 * Created by jt on 3/11/15.
 */
@Component
public class HelloWorldImpl implements HelloWorldService {

	@Override
	public void SayHello() {
		 System.out.println("Hello World!!!!");
		
	}

}

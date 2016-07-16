package guru.springframework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springboot.DependencyinjectionApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/spring/helloworld-config.xml", "classpath*:/spring/english-hello-world.xml"})
public class DependencyinjectionApplicationTests {

	@Test
	public void contextLoads() {
	}

}

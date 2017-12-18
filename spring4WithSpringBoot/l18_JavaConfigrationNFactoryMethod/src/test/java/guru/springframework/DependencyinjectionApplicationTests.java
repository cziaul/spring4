package guru.springframework;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import springboot.DependencyinjectionApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DependencyinjectionApplication.class)
public class DependencyinjectionApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void doTest(){
		
	}

}

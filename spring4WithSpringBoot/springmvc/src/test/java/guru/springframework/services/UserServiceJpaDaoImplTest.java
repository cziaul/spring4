package guru.springframework.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class UserServiceJpaDaoImplTest {
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Test
	public void testSaveOfUser() throws Exception{
		Users user = new Users();
		user.setUsername("someuser");
		user.setPassword("myPassword");
		
		Users savedUser = userService.saveOrUpdate(user);
		
		assert savedUser.getId() != null;
		assert savedUser.getPassword() != null;
		
		System.out.println("Encrypted Password ");
		System.out.println(savedUser.getEncryptedPassword());
				
	}
	
	
	
	
	

}

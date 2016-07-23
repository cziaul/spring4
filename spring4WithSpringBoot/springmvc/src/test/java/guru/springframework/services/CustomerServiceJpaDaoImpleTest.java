package guru.springframework.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class CustomerServiceJpaDaoImpleTest {
	
	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@Test
	public void testList() throws Exception{
		List<Customer> customer = (List<Customer>) customerService.listAll();
		assert customer.size() == 3;
	}
	
	@Test
	public void testSaveWithUser(){
		Customer customer = new Customer();
		Users user = new Users();
		user.setUsername("This is my user name");
		user.setPassword("MyAwesomePasswo");
		customer.setUser(user);
		
		Customer savedCustomer = customerService.saveOrUpdate(customer);
		assert savedCustomer.getUser().getId() != null;
	}
	

	
	
	

}

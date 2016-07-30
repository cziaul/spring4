package guru.springframework.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Cart;
import guru.springframework.domain.CartDetail;
import guru.springframework.domain.Customer;
import guru.springframework.domain.Product;
import guru.springframework.domain.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class UserServiceJpaDaoImplTest {
	
	private UserService userService;
	private ProductService productService;
	 
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Test
	public void testSaveOfUser() throws Exception{
		Users user = new Users();
		user.setUsername("someuser");
		user.setPassword("myPassword");
		
		//Adding Customer Object
		
		Customer customer = new Customer();
		customer.setFirstName("Zia");
		customer.setLastName("Chowdhury");
		user.setCustomer(customer);
		
		//Had to change to Users since user is protected in oracle db.
		
		Users savedUser = userService.saveOrUpdate(user);
		
		assert savedUser.getId() != null;
		assert savedUser.getVersion() != null;
		assert savedUser.getCustomer() != null;
		assert savedUser.getCustomer().getId() != null;
		
		/*assert savedUser.getPassword() != null;
		System.out.println("Encrypted Password ");
		System.out.println(savedUser.getEncryptedPassword());*/
				
	}
	
	@Test
	public void testAddCartToUser() throws Exception{
		Users user = new Users();
		user.setUsername("somesuer");
		user.setPassword("myPassword");
		
		user.setCart(new Cart());
		
		Users savedUser = userService.saveOrUpdate(user);
		
		assert savedUser.getId() != null;
		assert savedUser.getVersion() != null;
		assert savedUser.getCart() != null;
		assert savedUser.getCart().getId() != null;
	}
	
	 @Test
	    public void testAddCartToUserWithCartDetails() throws Exception {
	        Users user = new Users();

	        user.setUsername("someusername");
	        user.setPassword("myPassword");

	        user.setCart(new Cart());

	        List<Product> storedProducts = (List<Product>) productService.listAll();

	        CartDetail cartItemOne = new CartDetail();
	        cartItemOne.setProduct(storedProducts.get(0));
	        user.getCart().addCartDetails(cartItemOne);

	        CartDetail cartItemTwo = new CartDetail();
	        cartItemTwo.setProduct(storedProducts.get(1));
	        user.getCart().addCartDetails(cartItemTwo);

	        Users savedUser = userService.saveOrUpdate(user);

	        assert savedUser.getId() != null;
	        assert savedUser.getVersion() != null;
	        assert savedUser.getCart() != null;
	        assert savedUser.getCart().getId() != null;
	        assert savedUser.getCart().getCartDetails().size() == 2;
	    }

	    @Test
	    public void testAddAndRemoveCartToUserWithCartDetails() throws Exception {
	        Users user = new Users();

	        user.setUsername("someusername");
	        user.setPassword("myPassword");

	        user.setCart(new Cart());

	        List<Product> storedProducts = (List<Product>) productService.listAll();

	        CartDetail cartItemOne = new CartDetail();
	        cartItemOne.setProduct(storedProducts.get(0));
	        user.getCart().addCartDetails(cartItemOne);

	        CartDetail cartItemTwo = new CartDetail();
	        cartItemTwo.setProduct(storedProducts.get(1));
	        user.getCart().addCartDetails(cartItemTwo);

	        Users savedUser = userService.saveOrUpdate(user);

	        assert savedUser.getCart().getCartDetails().size() == 2;

	        savedUser.getCart().removeCartDetails(savedUser.getCart().getCartDetails().get(0));

	        userService.saveOrUpdate(savedUser);

	        assert savedUser.getCart().getCartDetails().size() == 1;
	}
	
	
	

}

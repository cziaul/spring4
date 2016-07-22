package guru.springframework.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import guru.springframework.config.JpaIntegrationConfig;
import guru.springframework.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
//@ActiveProfiles("jpa")
public class ProductServiceJpaDaoImplTest {
	
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@Test
	public void testListMethod() throws Exception{
		List<Product> products = (List<Product>) productService.listAll();
		System.out.println("Product Size is "+products.size());
		assert products.size()==4 ;
	}
	

	
}

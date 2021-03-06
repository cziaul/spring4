package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;

@Controller
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//Show all product
	@RequestMapping("/products")
	public String listProducts(Model model){
		
		model.addAttribute("products", productService.listAll());
		return "products"; //returning to html page in templates folder
	}
	//View 
	@RequestMapping("/product/{id}")
	public String getProduct(@PathVariable Integer id,  Model model){
		
		model.addAttribute("product", productService.getById(id));
		return "product";
	}
	//Add New
	@RequestMapping("/product/new")
	public String newProduct(Model model){
		model.addAttribute("product", new Product());
		return "productform";
	}
	//Save or Update
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String saveOrUpdateProduct(Product product){
		Product saveProduct= productService.saveOrUpdate(product);
		return "redirect:/product/" + saveProduct.getId();
	}
	//Edit a Product
	@RequestMapping("product/edit/{id}")
	public String edit (@PathVariable Integer id,  Model model){
		model.addAttribute("product", productService.getById(id));
		return "productform";
	}
	//Delete a Project
	@RequestMapping("/product/delete/{id}")
	public String delete(@PathVariable Integer id){
		productService.delete(id);
		return "redirect:/products";
	}

}

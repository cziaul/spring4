package guru.springframework.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Cart implements DomainObject{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Version
	private Integer version;
	
	@OneToOne
	private Users user;

	/*
	 * we are going to have cart id property and we are telling JPA to mapped by cart. if we don't add this by default JPA will 
	 * look for join table relationship and we don't want that. We want foreign key relationship
	 */
	
	// if we ever delete Cart orphanRemoval will auto remove cartDetails
	@OneToMany(cascade = CascadeType.ALL, mappedBy="cart", orphanRemoval= true)
	private List<CartDetail> cartDetails = new ArrayList<>();
		
	@Override
	public Integer getId() {
		return id;
	}
	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}
	
	public void addCartDetails(CartDetail cartDetails) {
		this.cartDetails.add(cartDetails);
		cartDetails.setCart(this);
	}
	public void removeCartDetails(CartDetail cartDetails) {
		cartDetails.setCart(null);
		this.cartDetails.remove(cartDetails);
	}
	
	
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	

	
}

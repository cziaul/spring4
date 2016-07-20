package guru.springframework.services.jpaservices;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;
import guru.springframework.services.security.EncryptionService;

@Service
@Profile("jpa")

public class ProductServiceJpaDaoImpl extends AbstructJpaDaoService implements ProductService {
	
	private EncryptionService encryptionService;
	
	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<Product> listAll() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Product", Product.class).getResultList();
	}

	@Override
	public Product getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Product.class, id);
	}

	@Override
	public Product saveOrUpdate(Product product) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		//Merge will handle update or save.
		Product saveProduct = em.merge(product);
		em.getTransaction().commit();
		return saveProduct;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Product.class, id));
		em.getTransaction().commit();
	}

}

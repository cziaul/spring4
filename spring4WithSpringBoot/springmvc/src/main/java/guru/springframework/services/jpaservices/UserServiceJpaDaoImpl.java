package guru.springframework.services.jpaservices;

import java.util.List;

import javax.persistence.EntityManager;

import org.dom4j.dom.DOMElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.domain.Users;
import guru.springframework.services.UserService;
import guru.springframework.services.security.EncryptionService;

@Service
@Profile("jpa")
public class UserServiceJpaDaoImpl extends AbstructJpaDaoService implements UserService {
	
	private EncryptionService encryptionService;
	
	
	@Autowired
	public void setEncryptionService(EncryptionService encryptionService) {
		this.encryptionService = encryptionService;
	}

	@Override
	public List<Users> listAll() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from User", Users.class).getResultList();
	}

	@Override
	public Users getById(Integer id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Users.class, id);
		
	}

	@Override
	public Users saveOrUpdate(Users domainObject) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		if(domainObject.getPassword() != null){
			domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
		}
		Users saveduser = em.merge(domainObject);
		em.getTransaction().commit();
		return saveduser;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Users.class, id));
		em.getTransaction().commit();

	}

}

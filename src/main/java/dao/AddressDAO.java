package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import model.Address;

@Repository
public class AddressDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void save(Address address){
		manager.persist(address);
	}
	
	public Address findByCEP(String cep){
		try {
			Query q = manager.createQuery("SELECT a FROM Address a where a.cep = :cep");
			q.setParameter("cep", cep);
			Address address = (Address) q.getSingleResult();
			return address;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}

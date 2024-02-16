package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.reader;

public class readerHelper {
	//variables
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ShoppingList");
	
	//methods
	public void insertReader(reader r) {EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<reader> showAllReaders() {
		EntityManager em =
		emfactory.createEntityManager();
		List<reader> allReaders = em.createQuery("SELECT r FROM reader r").getResultList();
		return allReaders;
	}
	
	public reader findReader(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<reader> typedQuery = em.createQuery("select r from reader r where r.readerName = :selectedName", reader.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		reader foundReader;
		try {
			foundReader = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundReader = new reader(nameToLookUp);
		}
		em.close();
		return foundReader;
	}
}

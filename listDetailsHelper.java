package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.listDetails;

public class listDetailsHelper {
	//variables
	static EntityManagerFactory emfactory =	Persistence.createEntityManagerFactory("ShoppingList");
	
	//methods
	public void insertNewListDetails(listDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<listDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<listDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
		return allDetails;
	}
	
	public void deleteList(listDetails toDelete) {
		EntityManager em =emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<listDetails> typedQuery = em.createQuery("select detail from ListDetailsdetail where detail.id = :selectedId", listDetails.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		listDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
		
	public listDetails searchForListDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		listDetails found = em.find(listDetails.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(listDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}

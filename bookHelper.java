package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.book;

public class bookHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("readingList");
	
	//methods
	public void insertBook(book b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}

	public List<book> showAllBooks(){
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<book> allBooks = em.createQuery("SELECT i FROM book i").getResultList();
		return allBooks;
	}
	
	public void deleteBook(book toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<book> typedQuery = em.createQuery("select b from book b where b.title = :selectedTitle and b.author = :selectedAuthor", book.class);
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTitle", toDelete.getTitle());
		typedQuery.setParameter("selectedAuthor", toDelete.getAuthor());
		//we only want one result
		typedQuery.setMaxResults(1);
		//get the result and save it into a new list item
		book result = typedQuery.getSingleResult();
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public book searchForBookById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		book found = em.find(book.class, idToEdit);
		em.close();
		return found;
	}

	public void updateBook(book toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<book> searchForBookByTitle(String title) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<book> typedQuery = em.createQuery("select b from book b where b.title = :selectedTitle", book.class);
			typedQuery.setParameter("selectedTitle", title);
			List<book> foundBooks = typedQuery.getResultList();
			em.close();
			return foundBooks;
	}

	public List<book> searchForBookByAuthor(String author) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<book> typedQuery = em.createQuery("select b from book b where b.author = :selectedAuthor", book.class);
		typedQuery.setParameter("selectedItem", author);
		List<book> foundBooks = typedQuery.getResultList();
		em.close();
		return foundBooks;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}

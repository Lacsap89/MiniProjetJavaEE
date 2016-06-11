package ch.hevs.libraryservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Writer;

@Stateless
public class LibraryBean implements Library{
	
	@PersistenceContext (name="libraryPU")
	private EntityManager em;
	

	public Book getBook(String title) {
		Query query = em.createQuery("FROM Book b WHERE b.title=:title");
		query.setParameter("title", title);
		
		return (Book) query.getSingleResult();
	}

	public Writer getWriter(String firstname, String lastname) {

		Query query = em.createQuery("FROM Writer w WHERE w.firstname=:firstname AND w.lastname=:lastname");
		query.setParameter("firstname", firstname);
		query.setParameter("lastname", lastname);
		return (Writer) query.getSingleResult();
	}


	public List<Book> getBooks() {
		
		return (List<Book>) em.createQuery("FROM Book");
	}


	public List<Writer> getWriter() {
		
		return (List<Writer>) em.createQuery("FROM Writer");
	}
	

}

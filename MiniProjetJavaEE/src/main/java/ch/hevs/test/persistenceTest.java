package ch.hevs.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.Test;

import ch.hevs.businessobject.AudioBook;
import ch.hevs.businessobject.AudioReader;
import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Ebook;
import ch.hevs.businessobject.Person;
import ch.hevs.businessobject.Writer;

public class persistenceTest {
	@Test
	public void test() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date birthDate = new Date();
		Date deathDate = new Date();
		EntityTransaction tx = null;
		try {

			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("libraryPU");
			EntityManager em = emf.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Category c1 = new Category("Science-fiction", "aventure dans un univers souvent futuriste mettant en avant les innovations technologiques");
			Category c2 = new Category("Fantasy", "Récits se déroulant dans des univers fantastiques, souvent d'inspiration médiévales");
			
			String birth="02/01/1920";
			String death="06/04/1992";
			
			birthDate = dateFormat.parse(birth);
			deathDate = dateFormat.parse(death);
			
			Writer w1 = new Writer("Isaac","Asimov", birthDate, deathDate);
			
			birth="03/01/1892";
			death="02/09/1973";
			
			birthDate = dateFormat.parse(birth);
			deathDate = dateFormat.parse(death);
			
			Writer w2 = new Writer("John Ronald Reuel", "Tolkien", birthDate, deathDate);
			
			String publication = "01/01/1951";
			Date publicationDate = dateFormat.parse(publication);
			Book b1 = new Book("Fondation", publicationDate, "9780553900347");
			
			publication = "29/08/1954";
			publicationDate = dateFormat.parse(publication);
			Book b2 = new Book("Le Seigneur des Anneaux", publicationDate, "9788845269707");
			
			b1.addCategory(c1);
			b1.addWriter(w1);
			
			b2.addCategory(c2);
			b2.addWriter(w2);
			
			birth="01/01/1933";
			birthDate=dateFormat.parse(birth);
			
			AudioReader a1= new AudioReader("Inglis", "Robert", birthDate);
			
			AudioBook ab1 = new AudioBook("Le Seigneur des Anneaux", publicationDate, "9788845269707");
			ab1.setAudioReader(a1);
			
			Ebook e1 = new Ebook("Le Seigneur des Anneaux", publicationDate, "pdf", "9788845269707", "Read only");
			
			
			
			
			
			
			tx.commit();
			

	
			/*Client c1 = new Client("Platini", "Michel", "former football player");
			Address a1 = new Address("75000", "Champs elyse", "Paris");
			c1.setAddress(a1);

			c1.addExternalAccount(new ExternalAccount("010101", "Account A"));
			c1.addExternalAccount(new ExternalAccount("020202", "Account B"));

			InternalAccount ci1 = new InternalAccount("1", "desc1", 1000);
			InternalAccount ci2 = new InternalAccount("2", "desc2", 2000);

			ci1.addOperation(new Operation("Boucher", 10, new Date()));
			ci1.addOperation(new Operation("Charcutier", 12, new Date()));

			ci2.addOperation(new Operation("Plasma", 10000, new Date()));
			ci2.addOperation(new Operation("Ipod", 450, new Date()));
			ci2.addOperation(new Operation("Nounou", 700, new Date()));

			c1.addInternalAccount(ci1);
			c1.addInternalAccount(ci2);

			Client c2 = new Client("Parker", "Tony", "Basketeur");
			Address a2 = new Address("XXXX", "Parc privé", "San Antonio");
			c2.setAddress(a2);

			c2.addExternalAccount(new ExternalAccount("88888", "Account de Denis"));
			c2.addExternalAccount(new ExternalAccount("77777",
					"Account epargne en suisse"));

			InternalAccount ci3 = new InternalAccount("3", "desc3", 3000);
			ci3.addOperation(new Operation("Boite de nuit", 10000, new Date()));
			ci3.addOperation(new Operation("Prada", 1000, new Date()));

			c2.addInternalAccount(ci2); // compte partagé avec Michel platini
										// :-)
			c2.addInternalAccount(ci3);

			Agency a = new Agency();
			a.addClient(c1);
			a.addClient(c2);

			Banker b1 = new Banker("Alexandre", "Jardin",
					"alex@hevs.ch");
			Banker b2 = new Banker("Marguerite", "Duras",
					"duras@hevs.ch");

			a.addEmployee(b1);
			a.addEmployee(b2);

			Address a3 = new Address("01", "A coté du lac leman", "Lausanne");
			a.setAddress(a3);

			em.persist(a);
			tx.commit();
*/
		} catch (Exception e) {
			e.printStackTrace();
			/*
			 * try { tx.rollback(); } catch (IllegalStateException e1) {
			 * e1.printStackTrace(); } catch (SecurityException e1) {
			 * e1.printStackTrace(); } catch (SystemException e1) {
			 * e1.printStackTrace(); }
			 */
		}

	}
}

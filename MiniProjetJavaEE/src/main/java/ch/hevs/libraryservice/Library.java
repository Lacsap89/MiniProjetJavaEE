package ch.hevs.libraryservice;

import java.util.List;

import ch.hevs.businessobject.Book;
import ch.hevs.businessobject.Category;
import ch.hevs.businessobject.Writer;

public interface Library {
	
	Book getBook(String title);
	
	Writer getWriter(String firstname, String lastname);
	
	List<Book> getBooks();
	
	List<Writer> getWriter();
	
	List<Category> getBookCategories();
	
	List<Book> getBooksByCategory(Category category);
	
	List<Book> getBooksByWriter(Writer writer);

}

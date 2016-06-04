package ch.hevs.businessobject;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class AudioReader extends Person {
	
	//Relations
	@OneToMany(mappedBy ="reader", cascade = CascadeType.REMOVE) //TODO trouver le cascade type correct
	private Set<AudioBook> audioBooks;
	
	//Constructor
	public AudioReader() {
		super();
		
	}

	public AudioReader(long id, String firstname, String lastname, Date birthday, Date deathday) {
		super(id, firstname, lastname, birthday, deathday);
		
	}

}

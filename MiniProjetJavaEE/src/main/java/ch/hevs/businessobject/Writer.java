package ch.hevs.businessobject;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Writer extends Person{

	public Writer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Writer(String firstname, String lastname, Date birthday, Date deathday) {
		super(firstname, lastname, birthday, deathday);
		// TODO Auto-generated constructor stub
	}

	
}

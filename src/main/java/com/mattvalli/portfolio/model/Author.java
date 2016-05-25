package com.mattvalli.portfolio.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.Model.UserSystem.Person;
import com.mattvalli.portfolio.dao.AuthorDao;

@Entity
@Table(name = AuthorDao.DATABASE + "." + AuthorDao.TABLE)
public class Author extends AbstractModelClass {
	// PROPERTIES
	@OneToOne
	@JoinColumn(name = AuthorDao.JOIN_PERSON)
	private Person mAuthor;
	
	@OneToMany(mappedBy = AuthorDao.TABLE, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = AuthorDao.JOIN_ASSOCIATE_BOOK_AUTHOR)
	private ArrayList<AssociateBookAuthor> mBooks;
	
	// CONSTRUCTOR
	public Author() {
		// Empty
	}
	
	public Author(Person person, ArrayList<AssociateBookAuthor> books) {
		this.mAuthor 	= person;
		this.mBooks		= books;
	}
	
	public Author(Person person) {
		this.mAuthor 	= person;
		this.mBooks		= null;
	}
	
	// CONVENIENCE METHODS
	public String getName() {
		return this.mAuthor.getName();
	}
}

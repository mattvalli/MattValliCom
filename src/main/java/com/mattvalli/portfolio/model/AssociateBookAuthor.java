package com.mattvalli.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.Model.UserSystem.Person;
import com.mattvalli.portfolio.dao.AssociateBookAuthorDao;

@Entity
@Table(name = AssociateBookAuthorDao.DATABASE + "." + AssociateBookAuthorDao.TABLE)
public class AssociateBookAuthor extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Id
	@Column(name = AssociateBookAuthorDao.COLUMN_ID)
	Integer mId;
	
	@ManyToOne
	@JoinColumn(name = AssociateBookAuthorDao.COLUMN_BOOK)
	Book 	mBook;
	
	@Id
	@ManyToOne
	@JoinColumn(name = AssociateBookAuthorDao.COLUMN_AUTHOR)
	Person mAuthor;
	
	// CONSTRUCTORS
	public AssociateBookAuthor() {
		// Empty
	}
	
	public AssociateBookAuthor(	Integer id, 
								Book book, 
								Person author) {
		this.mId		= id;
		this.mBook 		= book;
		this.mAuthor	= author;
	}
	
	// SETTERS
	public void setId(Integer id) {
		this.mId = id;
	}
	public void setBook(Book book) {
		this.mBook = book;
	}

	public void setAuthor(Person author) {
		this.mAuthor = author;
	}
	
	// GETTERS
	public Integer getId() {
		return this.mId;
	}
	public Book getBook() {
		return this.mBook;
	}

	public Person getAuthor() {
		return this.mAuthor;
	}
}

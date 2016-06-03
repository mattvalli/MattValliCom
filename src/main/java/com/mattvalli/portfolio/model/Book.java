package com.mattvalli.portfolio.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.BookDao;

@Entity
@Table(name = BookDao.DATABASE + "." + BookDao.TABLE)
public class Book extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@NotNull
	@Column(name = BookDao.COLUMN_TITLE, nullable = false)
	public String mTitle;
	
	@Column(name = BookDao.COLUMN_SUBTITLE, nullable = true)
	public String mSubtitle;
	
	@Column(name = BookDao.COLUMN_ISBN, nullable = true)
	public String mISBN;
	
	@Column(name = BookDao.COLUMN_DESC, nullable = true)
	public String mDescription;
	
	@Column(name = BookDao.COLUMN_COVER_IMG, nullable = true)
	public String mCoverImageURI;
	
	
	//@OneToMany(mappedBy = CLASSNAME, cascade = CascadeType.ALL, orphanRemoval = true)
	public List<AssociateBookAuthor> mAuthors;
	
	//@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<String> mTableOfConents;
	
	
	public List<Chapter> mChapters;
	
	
	// CONSTRUCTORS
	public Book() {
		// Empty
	}
	
	public Book(	Integer id, 
					String title,
					String subtitle,
					ArrayList<AssociateBookAuthor> authors,
					String isbn,
					String description			) {
		// Set all Properties
		this.mId				= id;
		this.mTitle 			= title;
		this.mSubtitle		= subtitle;
		this.mAuthors		= authors;
		this.mISBN			= isbn;
		this.mDescription	= description;
	}
	
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("BOOK OBJECT" 			+ "\n");
		output.append("ID: " 			+ Integer.toString(this.mId) 	+ "\n");
		output.append("ISBN: " 			+ this.mISBN 					+ "\n");
		output.append("Title: " 		+ this.mTitle 					+ "\n");
		output.append("Subtitle: " 		+ this.mSubtitle 				+ "\n");
		
		// Loop through Authors
		output.append("Authors: ");
		Iterator<AssociateBookAuthor> iterator = mAuthors.iterator();
		while (iterator.hasNext()) {
			output.append(((AssociateBookAuthor) iterator.next()).getAuthor().getName());
			if (iterator.hasNext()) output.append(", ");
		}
		output.append("\n");
		
		// Output Description
		output.append("Description: " 	+ this.mDescription 				+ "\n");
		
		return output.toString();
	}
	
	// POLYMORPHIC FUNCTIONS
	public boolean equals(Book b) {
		// If the object isn't of type Book, it cannot be equal, return false
		if ( 	! (b instanceof Book) 	) return false;
		
		// The object b is of type book
		// Check to see if both books share the same ISBN
		// Currently there are no more conditions
		if ( 	this.mISBN.equals( b.getISBN() )	) 	return true;
		
		return false;	
	}
	
	// METHODS
	
	// SETTERS
	public void setTitle(String title) {
		this.mTitle = title;
	}
	public void setSubtitle(String subtitle) {
		this.mSubtitle = subtitle;
	}
	public void setAuthors(List<AssociateBookAuthor> authors) {
		this.mAuthors = authors;
	}
	public void setISBN(String iSBN) {
		this.mISBN = iSBN;
	}
	public void setDescription(String description) {
		this.mDescription = description;
	}
	
	// GETTERS
	public String getTitle() {
		return this.mTitle;
	}
	public String getSubtitle() {
		return this.mSubtitle;
	}
	public List<AssociateBookAuthor> getAuthors() {
		return this.mAuthors;
	}
	public String getISBN() {
		return this.mISBN;
	}
	public String getDescription() {
		return this.mDescription;
	}
}

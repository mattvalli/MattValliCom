package com.mattvalli.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mattvalli.portfolio.dao.AssociateBookChapterDao;

@Entity
@Table(name = AssociateBookChapterDao.DATABASE + "." + AssociateBookChapterDao.TABLE)
public class AssociateBookChapter {
	// PROPERTIES
	@Id
	@Column(name = AssociateBookChapterDao.COLUMN_ID)
	private Integer		mId;
	
	@ManyToMany
	@JoinColumn(name = AssociateBookChapterDao.JOIN_BOOK)
	private Book		mBook;
	
	@ManyToMany
	@JoinColumn(name = AssociateBookChapterDao.JOIN_CHAPTER)
	private Chapter 	mChapter;
	
	@Column(name = AssociateBookChapterDao.COLUMN_ORDER_SORT)
	private Integer		mOrderSort;
	
	// CONSTRUCTOR
	public AssociateBookChapter() {
		// Empty
	}
	
	public AssociateBookChapter(Integer id, 
								Book 	book, 
								Chapter	chapter,
								Integer	position	) {
		this.mId 			= id;
		this.mBook 			= book;
		this.mChapter 		= chapter;
		this.mOrderSort		= position;
		
	}
	
	// SETTERS
	public void setId(Integer id) {
		this.mId = id;
	}

	public void setBook(Book book) {
		this.mBook = book;
	}

	public void setChapter(Chapter chapter) {
		this.mChapter = chapter;
	}

	public void setOrderSort(Integer orderSort) {
		this.mOrderSort = orderSort;
	}
	
	// GETTERS
	public Integer getId() {
		return this.mId;
	}

	public Book getBook() {
		return this.mBook;
	}

	public Chapter getChapter() {
		return this.mChapter;
	}

	public Integer getOrderSort() {
		return this.mOrderSort;
	}
	
	
}

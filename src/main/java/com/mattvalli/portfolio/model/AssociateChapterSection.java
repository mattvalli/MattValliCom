package com.mattvalli.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mattvalli.portfolio.dao.AssociateChapterSectionDao;

@Entity
@Table(name = AssociateChapterSectionDao.DATABASE + "." + AssociateChapterSectionDao.TABLE)
public class AssociateChapterSection {
	// CONSTANTS
	
	// PROPERTIES
	@Id
	@Column(name = AssociateChapterSectionDao.COLUMN_ID)
	private Integer 	mId;
	
	@ManyToOne
	@JoinColumn(name = AssociateChapterSectionDao.JOIN_CHAPTER)
	private Chapter 	mChapter;
	
	@ManyToOne
	@JoinColumn(name = AssociateChapterSectionDao.JOIN_SECTION)
	private Section 	mSection;
	
	@Column(name = AssociateChapterSectionDao.COLUMN_ORDER_SORT)
	private Integer 	mOrderSort;
	
	// CONSTRUCTORS
	public AssociateChapterSection() {
		// Empty
	}
	
	public AssociateChapterSection(	Integer id,
									Chapter chapter,
									Section section,
									Integer position	) {
		// Set Properties
		this.mId 			= id;
		this.mChapter 		= chapter;
		this.mSection 		= section;
		this.mOrderSort 	= position;
	}

	// SETTERS
	public void setId(Integer id) {
		this.mId = id;
	}

	public void setChapter(Chapter chapter) {
		this.mChapter = chapter;
	}

	public void setSection(Section section) {
		this.mSection = section;
	}

	public void setOrderSort(Integer orderSort) {
		this.mOrderSort = orderSort;
	}
	
	// GETTERS
	public Integer getId() {
		return this.mId;
	}

	public Chapter getChapter() {
		return this.mChapter;
	}

	public Section getSection() {
		return this.mSection;
	}

	public Integer getOrderSort() {
		return this.mOrderSort;
	}
	
}

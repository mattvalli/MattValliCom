package com.mattvalli.portfolio.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.ChapterDao;

@Entity
@Table(name = ChapterDao.DATABASE + "." + ChapterDao.TABLE)
public class Chapter extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name = ChapterDao.COLUMN_SUBTITLE)
	private String mSubtitle;
	
	@OneToMany
	@JoinColumn(name = ChapterDao.JOIN_ASSOCIATE_CHAPTER_SECTION)
	private ArrayList<Integer> mSections;
	
	// CONSTRUCTORS
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	
	// GETTERS
	
}

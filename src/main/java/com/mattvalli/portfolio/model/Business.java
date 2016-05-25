package com.mattvalli.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.BusinessDao;

@Entity
@Table(name = BusinessDao.DATABASE + "." + BusinessDao.TABLE)
public class Business extends AbstractModelClass {
	// PROPERTIES
	@Column(name = BusinessDao.COLUMN_NAME)
	public String mName;
	
	// CONSTRUCTORS
	public Business() {
		// Empty
	}
	
	public Business(Integer id, String displayName, String businessName) {
		// Set Properties
		mId 			= id;
		mDisplayName 	= displayName;
		mName 			= businessName;
	}
	
	// SETTERS
	public void setName(String name) {
		mName = name;
	}
	
	// GETTERS
	public String getName() {
		return mName;
	}
}

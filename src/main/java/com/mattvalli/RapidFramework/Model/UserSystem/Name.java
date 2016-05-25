package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.NameDao;

@Entity
@Table(name = NameDao.ENTITY)
public class Name {
	
	// PROPERTIES
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer mId;
	
	@NaturalId
	@Column(name = NameDao.COLUMN_NAME, unique = true)
	public String mName;
	
	// CONSTRUCTOR
	public Name() {
		// Empty
	}
	
	public Name(Integer id, String name) {
		this.mId 	= id;
		this.mName 	= name;
	}
	
	public Name(String name) {
		this.mId 	= AbstractModelClass.INVALID_ID;
		this.mName	= name;
	}

	// SETTERS
	public void setId(Integer id) {
		this.mId = id;
	}

	public void setName(String name) {
		this.mName = name;
	}
	
	// GETTERS
	public Integer getId() {
		return this.mId;
	}

	public String getName() {
		return this.mName;
	}
	
}

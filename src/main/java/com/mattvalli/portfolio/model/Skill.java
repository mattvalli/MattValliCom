package com.mattvalli.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.SkillDao;

@Entity
@Table(name = SkillDao.DATABASE + "." + SkillDao.TABLE)
public class Skill extends AbstractModelClass {
	// CONSTANTS

	// PROPERTIES
	@Column(name = SkillDao.COLUMN_NAME)
	String mName;
	
	@Column(name = SkillDao.COLUMN_DESCRIPTION)
	String mDescription;
	
	// CONSTRUCTORS
	public Skill() {
		// Empty
	}
	
	public Skill(	Integer id, 
					String displayName, 
					String description	) {
		// Set All Properties
		this.mId 			= id;
		this.mDisplayName 	= displayName;
		this.mDescription 	= description;
	}
	
	public Skill(	String displayName, 
					String description	) {
		this(AbstractModelClass.INVALID_ID, displayName, description);
	}
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	public void setName(String name) {
		this.mName = name;
	}
	public void setDescription(String description) {
		this.mDescription = description;
	}
	
	// GETTERS
	public String getName() {
		return this.mName;
	}
	public String getDescription() {
		return this.mDescription;
	}

}

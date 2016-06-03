package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.GenderDao;

@Entity
@Table(name = GenderDao.DATABASE + "." + GenderDao.TABLE)
public class Gender extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name  = GenderDao.COLUMN_ENUM_VALUE)
	private Integer mEnumValue;
	
	@Column(name = GenderDao.COLUMN_ENUM_LABEL)
	private String mEnumLabel;
	
	// CONSTRUCTORS
	public Gender() {
		// Empty
	}
	
	public Gender(	Integer id,
					String 	displayName,
					String	enumLabel,
					Integer	enumValue		) {
		this.mId 			= id;
		this.mDisplayName 	= displayName;
		this.mEnumLabel		= enumLabel;
		this.mEnumValue		= enumValue;
	}
	
	public Gender(GenderType type) {
		// TODO CONVERT GENDER TYPE TO GENDER OBJECT
	}
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	public void setEnumValue(Integer enumValue) {
		mEnumValue = enumValue;
	}

	public void setEnumLabel(String enumLabel) {
		mEnumLabel = enumLabel;
	}
	
	// GETTERS
	public Integer getEnumValue() {
		return mEnumValue;
	}

	public String getEnumLabel() {
		return mEnumLabel;
	}
}

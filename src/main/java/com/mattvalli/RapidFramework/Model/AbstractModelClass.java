package com.mattvalli.RapidFramework.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.mattvalli.RapidFramework.Model.UserSystem.ModificationLog;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractModelClass {
	// CONSTANTS
	public static final Integer INVALID_ID = -1;
	public static final String COLUMN_DISPLAY_NAME 	= "display_name";
	public static final String COLUMN_MOD_LOG		= "fk_log_modification";
	
	// PROPERTIES
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected Integer 			mId;
	
	@NotNull
	@Column(name = COLUMN_DISPLAY_NAME)
	protected String 			mDisplayName;
	
	
	// @OneToMany 
	protected ModificationLog mModificationLog;
	
	// METHODS
	
	// SETTERS
	public void setId(Integer id) {
		this.mId = id;
	}
	
	public void setDisplayName(String displayName) {
		this.mDisplayName = displayName;
	}
	
	public void setModificationLog(ModificationLog log) {
		this.mModificationLog	= log;
	}
	
	// GETTERS
	public Integer getId() {
		return this.mId;
	}
	
	public String getDisplayName() {
		return this.mDisplayName;
	}
	
	public ModificationLog getModificationLog() {
		return this.mModificationLog;
	}
	
}
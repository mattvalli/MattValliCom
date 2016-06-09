package com.mattvalli.RapidFramework.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

import net.sf.cglib.beans.BeanCopier.Generator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractModelClass {
	// CONSTANTS
	public static final Integer INVALID_ID = -1;
	public static final String COLUMN_DISPLAY_NAME 	= "display_name";
	public static final String COLUMN_MOD_LOG		= "fk_log_modification";
	
	// PROPERTIES
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id")
	protected Integer 			mId;
	
	//@NotNull
	@Column(name = COLUMN_DISPLAY_NAME)
	protected String 			mDisplayName;
	
	
	// @OneToMany 
	//protected ModificationLog mModificationLog;
	
	// METHODS
	
	// SETTERS
	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.mId = id;
	}
	
	public void setDisplayName(String displayName) {
		this.mDisplayName = displayName;
	}
	
	/*
	public void setModificationLog(ModificationLog log) {
		this.mModificationLog	= log;
	}
	*/
	
	// GETTERS
	public Integer getId() {
		return this.mId;
	}
	
	public String getDisplayName() {
		return this.mDisplayName;
	}
	
	/*
	public ModificationLog getModificationLog() {
		return this.mModificationLog;
	}
	*/
	
}

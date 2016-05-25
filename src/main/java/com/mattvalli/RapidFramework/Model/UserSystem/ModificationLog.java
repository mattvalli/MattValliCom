package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.mattvalli.RapidFramework.dao.UserSystem.ModificationLogDao;

@Entity
@Table(name = ModificationLogDao.DATABASE + "." + ModificationLogDao.TABLE)
public class ModificationLog {
	// CONSTANTS
	
	// PROPERTIES
	@Id
	@Column(name = ModificationLogDao.COLUMN_ID)
	private Integer mId;
	
	@Column(name = ModificationLogDao.COLUMN_TABLE_NAME)
	private String mTableName;
	
	@Column(name = ModificationLogDao.COLUMN_RECORD_ID)
	private Integer mRecordId;
	
	@Column(name = ModificationLogDao.COLUMN_VERSION)
	private Integer mVersion;
	
	@Column(name = ModificationLogDao.COLUMN_USER_ID)
	private Integer mUserCreated;
	
	@DateTimeFormat(pattern = ModificationLogDao.DATE_FORMAT)
	@Column(name = ModificationLogDao.COLUMN_DATE_CREATED)
	private LocalDateTime mDateCreated;
	
	// CONSTRUCTORS
	public ModificationLog() {
		// Empty
	}
	
	public ModificationLog(	Integer id, 
							String table, 
							Integer recordId, 
							Integer version, 
							Integer userId,
							LocalDateTime dateCreated) {
		// Set Properties
		this.mId 			= id;
		this.mTableName 	= table;
		this.mRecordId 		= recordId;
		this.mVersion		= version;
		this.mUserCreated	= userId;
		this.mDateCreated	= dateCreated;
	}

	// OVERRIDES
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// SETTERS
	public void setId(Integer id) {
		this.mId = id;
	}

	public void setTableName(String tableName) {
		this.mTableName = tableName;
	}

	public void setRecordId(Integer recordId) {
		this.mRecordId = recordId;
	}

	public void setVersion(Integer version) {
		this.mVersion = version;
	}

	public void setUserCreated(Integer userCreated) {
		this.mUserCreated = userCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.mDateCreated = dateCreated;
	}
	
	// GETTERS
	public Integer getId() {
		return this.mId;
	}

	public String getTableName() {
		return this.mTableName;
	}

	public Integer getRecordId() {
		return this.mRecordId;
	}

	public Integer getVersion() {
		return this.mVersion;
	}

	public Integer getUserCreated() {
		return this.mUserCreated;
	}

	public LocalDateTime getDateCreated() {
		return this.mDateCreated;
	}
}

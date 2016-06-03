package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;

@Entity
@Table( name = SocialMediaAccountDao.DATABASE + SocialMediaAccountDao.TABLE)
public class SocialMediaAccount extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@JoinColumn(name = SocialMediaAccountDao.COLUMN_ACCOUNT_OWNER)
	private String mAccountOwner;
	
	@Column(name = SocialMediaAccountDao.COLUMN_ACCOUNT_PROVIDER)
	private String mAccountProvider;
	
	@Column(name = SocialMediaAccountDao.COLUMN_USERNAME)
	private String mUsername;
	
	@Column(name = SocialMediaAccountDao.COLUMN_CREDENTIALS )
	private String mCredentials;
	
	// CONSTRUCTORS
	public SocialMediaAccount() {
		// Empty
	}
	
	public SocialMediaAccount(Integer id, String accountOwner, String displayName, String accountProvider, String username, String credentials) {
		// Set all Properties
		this.mId = id;
		this.mDisplayName 		= displayName;
		this.mAccountOwner		= accountOwner;
		this.mAccountProvider	= accountProvider;
		this.mUsername			= username;
		this.mCredentials		= credentials;
	}
	
	public SocialMediaAccount(String accountOwner, String accountSite, String username, String credentials) {
		this(AbstractModelClass.INVALID_ID, accountOwner, accountSite + " - " + username, accountSite, username, credentials);
	}

	// OVERRIDES
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// SETTERS
	public void setAccountOwner(String person) {
		this.mAccountOwner = person;
	}
	public void setAccountProvider(String provider) {
		this.mAccountProvider = provider;
	}

	public void setUsername(String username) {
		this.mUsername = username;
	}

	public void setCredentials(String credentials) {
		this.mCredentials = credentials;
	}
	
	// GETTERS
	public String getAccountOwner() {
		return this.mAccountOwner;
	}
	public String getAccountProvider() {
		return this.mAccountProvider;
	}

	public String getUsername() {
		return this.mUsername;
	}

	public String getCredentials() {
		return this.mCredentials;
	}
	
}

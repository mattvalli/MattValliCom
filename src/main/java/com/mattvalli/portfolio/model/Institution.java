package com.mattvalli.portfolio.model;

import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.Model.UserSystem.Address;
import com.mattvalli.portfolio.dao.InstitutionDao;

@Entity
@Table(name = InstitutionDao.DATABASE + "." + InstitutionDao.TABLE)
public class Institution extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name = InstitutionDao.COLUMN_NAME)
	private String mName;
	
	@OneToMany
	@JoinColumn(name = InstitutionDao.JOIN_TYPE_INSTITUTION, nullable = false)
	private InstitutionType mType;
	
	@OneToMany
	@JoinColumn(name = InstitutionDao.JOIN_ADDRESS)
	private Address 		mAddress;
	
	@OneToMany
	@JoinColumn(name = InstitutionDao.JOIN_URL)
	private URL		mWebHomepage;  // ****** This most likely should be replaced by a URI object
	
	
	// CONSTRUTORS
	public Institution(		Integer 	id,
							String 		displayName,
							Address 	address,
							URL			webHomepage		) {
		// Set Properties
		this.mId 			= id;
		this.mDisplayName 	= displayName;
		this.mAddress		= address;
		this.mWebHomepage	= webHomepage;
	}

			
	
	// OVERRIDES
	
	// METHODS
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("INSTITUTION OBJECT" 	+ "\n");
		
		output.append("Display Name: " 	+ this.mDisplayName 			+ "\n");
		output.append("Address: " 		+ this.mAddress 				+ "\n");
		output.append("Home Webpage: " 	+ this.mWebHomepage.toString() 	+ "\n");
		
		return output.toString();
	}
	
	// SETTERS
	public void setAddress(Address address) {
		this.mAddress = address;
	}

	public void setWebHomepage(URL webHomepage) {
		this.mWebHomepage = webHomepage;
	}
	
	// GETTERS
	public Address getAddress() {
		return this.mAddress;
	}

	public URL getWebHomepage() {
		return this.mWebHomepage;
	}
}

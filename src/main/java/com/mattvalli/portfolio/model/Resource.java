package com.mattvalli.portfolio.model;

import java.net.MalformedURLException;
import java.net.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.ResourceDao;

@Entity
@Table(name = ResourceDao.DATABASE + "." + ResourceDao.TABLE)
public class Resource extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@OneToMany
	@JoinColumn(name = ResourceDao.JOIN_TYPE_RESOURCE)
	private ResourceType 	mType;
	private URL				mUrl;
	
	// CONSTRUCTORS
	public Resource() {
		// Empty
	}
	
	public Resource(	Integer 		id,
						String 			displayName,
						URL				url,
						ResourceType	type			) {
		// Set all Properties
		mId 				= id;
		mDisplayName 		= displayName;
		mUrl				= url;
		mType				= type;
	}
	
	public Resource(String displayName, URL url, ResourceType type) {
		this(AbstractModelClass.INVALID_ID, displayName, url, type);
	}
	
	public Resource(URL url, ResourceType type) {
		this(AbstractModelClass.INVALID_ID, "", url, type);
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("RESOURCE OBJECT" + "\n");
		
		output.append("ID: " 			+ Integer.toString(mId) 	+ "\n");
		output.append("Display Name: " 	+ mDisplayName 				+ "\n");
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	public boolean equals(Object o) {
		if ( ! (o instanceof Resource) ) return false;
		
		// Object must be of type Resource
		Resource r = (Resource) o;
		
		// Equality conditions
		// CODE FOR DATABASE EQUALITY (Should be moved to DAO Object in the future to reduce data entry redundancies
				// If the Display Names are the same, the IDs are not equal, and the ID isn't the INVALID_ID Constant:
				// - then there is a repetitive entry in the Database
				if ( this.mId != r.getId() || this.mId != AbstractModelClass.INVALID_ID ) return false;
		
		return true;
	}
	
	// METHODS
	
	// SETTERS
	public void setType(ResourceType type) {
		mType = type;
	}

	@Column(name = ResourceDao.COLUMN_URL)
	public void setUrl(String url) throws MalformedURLException {
		mUrl = new URL(url);
	}
	
	public void setUrl(URL url) {
		mUrl = url;
	}
	
	// GETTERS
	public ResourceType getType() {
		return mType;
	}

	public URL getUrl() {
		return mUrl;
	}
	
	@Column(name = ResourceDao.COLUMN_URL)
	public String getUrlAsString() {
		if (mUrl == null) return null;
		return mUrl.toString();
	}
}

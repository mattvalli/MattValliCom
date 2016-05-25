package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.ContactDao;

@Entity
@Table(name = ContactDao.DATABASE + "." + ContactDao.TABLE)
public class Contact extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	private Person			mPerson;
	private String			mEmailPrimary;
	private String			mEmailSecondary;
	private String			mEmailBusinessPrimary;
	private String			mEmailBusinessSecondary;
	private PhoneNumber 	mHome;
	private PhoneNumber 	mMobilePrimary;
	private PhoneNumber 	mMobileSecondary;
	private PhoneNumber 	mWorkOffice;
	private PhoneNumber 	mWorkMobile;
	private Address 		mHomeAddress;
	private Address 		mPerminentAddress;
	private Address 		mMailingAddress;
	
	
	// CONSTRUCTORS
	public Contact() {
		// Empty
	}
	
	// OVERRIDES
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// SETTERS
	
	// GETTERS
	
}

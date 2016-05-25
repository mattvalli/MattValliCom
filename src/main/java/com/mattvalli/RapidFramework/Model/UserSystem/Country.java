package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.CountryDao;

@Entity
@Table(name = CountryDao.DATABASE + "." + CountryDao.TABLE)
public class Country extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	private CountryEnum 	mCountryEnum;
	private String 			mPhoneCountryCode;
	private String 			mAbbreviation;
	
	// CONSTRUCTORS
	public Country() {
		mId = AbstractModelClass.INVALID_ID;
	}
	
	public Country(	Integer 		id,
					CountryEnum 	country,
					String			countryName,
					String			phoneCountryCode,
					String			countryAbbreviation	) {
		// Set all Properties
		mId					= id;
		mDisplayName		= countryName;
		mCountryEnum		= country;
		mPhoneCountryCode	= phoneCountryCode;
		mAbbreviation		= countryAbbreviation;
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("COUNTRY OBJECT" + "\n");
		
		output.append("ID: " 					+ Integer.toString(mId) 	+ "\n");
		output.append("Country/Display Name: "  + mDisplayName 				+ "\n");
		output.append("Phone Country Code: " 	+ mPhoneCountryCode 		+ "\n");
		output.append("Abbriviation: " 			+ mAbbreviation				+ "\n");
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	public boolean equals(Object o) {
		if ( ! (o instanceof Country) ) return false;
		
		// Object must be of type Country
		Country c = (Country) o;
		
		// Equality Conditions
		if ( 	! (this.mDisplayName.equals(		c.getDisplayName()		))		) return false;
		if ( 	! (this.mPhoneCountryCode.equals(	c.getPhoneCountryCode()	)) 		) return false;
		if ( 	! (this.mAbbreviation.equals(	c.getAbbreviation()			)) 		) return false;
		
		return true;
	}

	// METHODS
	
	// SETTERS
	public void setCountryConstant(CountryEnum country) {
		mCountryEnum = country;
	}
	
	public void setPhoneCountryCode(String phoneCountryCode) {
		mPhoneCountryCode = phoneCountryCode;
	}

	public void setAbbreviation(String abbreviation) {
		mAbbreviation = abbreviation;
	}
	
	// GETTERS
	public CountryEnum getCountryConstant() {
		return mCountryEnum;
	}
	
	public String getPhoneCountryCode() {
		return mPhoneCountryCode;
	}

	public String getAbbreviation() {
		return mAbbreviation;
	}
}

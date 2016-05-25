package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.PhoneNumberDao;

@Entity
@Table(name = PhoneNumberDao.DATABASE + "," + PhoneNumberDao.TABLE)
public class PhoneNumber extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@JoinColumn(name = PhoneNumberDao.JOIN_COUNTRY)
	private Country 			mCountry;
	
	@Column(name = PhoneNumberDao.COLUMN_CODE_COUNTRY)
	private String				mCountryCode;
	
	@Column(name = PhoneNumberDao.COLUMN_CODE_AREA)
	private String				mAreaCode;
	
	@Column(name = PhoneNumberDao.COLUMN_PREFIX)
	private String				mPrefix;
	
	@Column(name = PhoneNumberDao.COLUMN_POSTFIX)
	private String				mPostfix;
	
	@Column(name = PhoneNumberDao.COLUMN_EXTENSION)
	private String				mExtension;
	
	//@JoinColumn(name = PhoneNumberDao.JOIN_ROUTE_MAP)
	//private PhoneRouteMap mRouteMap;
	
	// CONSTRUCTORS
	public PhoneNumber() {
		mId = AbstractModelClass.INVALID_ID;
	}
	
	public PhoneNumber(	Integer id,
						String	displayName,
						Country country,
						String 	countryCode,
						String	areaCode,
						String	prefix,
						String 	postfix,
						String 	extension	) {
		// Set all Properties
		mId				= id;
		mDisplayName	= displayName;
		mCountry		= country;
		mCountryCode	= countryCode;
		mAreaCode		= areaCode;
		mPrefix			= prefix;
		mPostfix		= postfix;
		mExtension		= extension;
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("PHONE NUMBER OBJECT" + "\n");
		
		output.append("ID: " + Integer.toString(mId) + "\n");
		output.append("Display Name: " + mDisplayName + "\n");
		output.append("Country: " + mCountry.getDisplayName() + "\n");
		output.append("Country Code: " + mCountry.getPhoneCountryCode() + "\n");
		output.append("Main Line: " + mPrefix + "-" + mPostfix + "\n");
		output.append("Extension: " + mExtension + "\n");
		output.append("Common Phone Format: " + this.getCommonPhoneFormat() + "\n");
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	
	// METHODS
	public String getCommonPhoneFormat() {
		StringBuilder output = new StringBuilder();
		
		switch (mCountry.getCountryConstant()) {
			case USA:
			case CANADA:
				output.append("+" + mCountry.getPhoneCountryCode() + " (" + mAreaCode + ")" + mPrefix + "-" + mPostfix + "\n");
				if (mExtension != null || !mExtension.equals(""))	output.append(" Ext. " + mExtension);
				break;
		}
		
		return output.toString();
	}
	
	// SETTERS
	public void setCountry(Country country) {
		this.mCountry = country;
	}
	
	public void setCountryCode(String countryCode) {
		this.mCountryCode = countryCode;
	}

	public void setAreaCode(String areaCode) {
		this.mAreaCode = areaCode;
	}

	public void setPrefix(String prefix) {
		this.mPrefix = prefix;
	}
	
	public void setPostfix(String postfix) {
		this.mPostfix = postfix;
	}

	public void setExtension(String extension) {
		this.mExtension = extension;
	}
	
	// GETTERS
	public Country getCountry() {
		return this.mCountry;
	}

	public String getAreaCode() {
		return this.mAreaCode;
	}

	public String getPrefix() {
		return this.mPrefix;
	}
	
	public String getPostfix() {
		return this.mPostfix;
	}

	public String getExtension() {
		return this.mExtension;
	}
	
	public String getCountryCode() {
		return this.mCountryCode;
	}
}

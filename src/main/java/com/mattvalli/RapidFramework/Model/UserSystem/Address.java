package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.dao.UserSystem.AddressDao;

@Entity
@Table(name = AddressDao.DATABASE + "." + AddressDao.TABLE)
public class Address {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name = AddressDao.COLUMN_ID)
	private Integer mId;
	
	@Column(name = AddressDao.COLUMN_STREET_NUMBER)
	private String 		mStreetNumber;
	
	@Column(name = AddressDao.COLUMN_STREET)
	private String 		mStreet;
	
	@Column(name = AddressDao.COLUMN_UNIT)
	private String 		mUnit;
	
	@Column(name = AddressDao.COLUMN_BUILDING_NUMBER)
	private String 		mBuildingNumber;
	
	@Column(name = AddressDao.COLUMN_BUILDING_FLOOR)
	private String		mBuildingFloor;
	
	@Column(name = AddressDao.COLUMN_COMPLEX)
	private String 		mComplex;
	
	@Column(name = AddressDao.COLUMN_CITY)
	private String 		mCity;
	
	@Column(name = AddressDao.COLUMN_STATE)
	private String		mState;
	
	@Column(name = AddressDao.COLUMN_POSTAL_CODE)
	private String 		mPostalCode;
	
	@Column(name = AddressDao.COLUMN_COUNTRY)
	private String 		mCounrty;
	
	@Column(name = AddressDao.COLUMN_ADDRESS_TYPE)
	private AddressType mAddressType;
	
	@Column(name = AddressDao.COLUMN_NAME_BUSINESS)
	private String 		mBusinessName;
	
	@Column(name = AddressDao.COLUMN_CONTACT)
	private Contact 	mContact;
	
	// CONSTRUCTORS
	public Address() {
		// Empty
	}
	
	public Address(	String 		streetNumber, 
					String 		street, 
					String 		unit, 
					String		buildingNumber,
					String		buildingFloor,
					String		complex,
					String 		city, 
					String 		postalCode, 
					String 		country, 
					String 		businessName,
					AddressType type,
					Contact 	contact 	) {
		// Set Properties
		this.mStreetNumber 		= streetNumber;
		this.mStreet			= street;
		this.mUnit				= unit;
		this.mBuildingNumber	= buildingNumber;
		this.mBuildingFloor		= buildingFloor;
		this.mComplex			= complex;
		this.mCity				= city;
		this.mPostalCode		= postalCode;
		this.mCounrty			= country;
		this.mBusinessName		= businessName;
		this.mAddressType		= type;
		this.mContact			= contact;
	}	
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	public void setStreetNumber(String streetNumber) {
		this.mStreetNumber = streetNumber;
	}

	public void setStreet(String street) {
		this.mStreet = street;
	}

	public void setUnit(String unit) {
		this.mUnit = unit;
	}

	public void setBuilding(String buildingNumber) {
		this.mBuildingNumber = buildingNumber;
	}
	
	public void setBuildingFloor(String buildingFloor) {
		this.mBuildingFloor = buildingFloor;
	}

	public void setComplex(String complex) {
		this.mComplex = complex;
	}

	public void setCity(String city) {
		this.mCity = city;
	}

	public void setPostalCode(String postalCode) {
		this.mPostalCode = postalCode;
	}

	public void setCounrty(String counrty) {
		this.mCounrty = counrty;
	}

	public void setAddressType(AddressType addressType) {
		this.mAddressType = addressType;
	}

	public void setBusinessName(String businessName) {
		this.mBusinessName = businessName;
	}

	public void setContact(Contact contact) {
		this.mContact = contact;
	}
	
	// GETTERS
	public String getStreetNumber() {
		return this.mStreetNumber;
	}

	public String getStreet() {
		return this.mStreet;
	}

	public String getUnit() {
		return this.mUnit;
	}

	public String getBuildingNumber() {
		return this.mBuildingNumber;
	}
	
	public String getBuildingFloor() {
		return this.mBuildingFloor;
	}

	public String getComplex() {
		return this.mComplex;
	}

	public String getCity() {
		return this.mCity;
	}

	public String getPostalCode() {
		return this.mPostalCode;
	}

	public String getCounrty() {
		return this.mCounrty;
	}

	public AddressType getAddressType() {
		return this.mAddressType;
	}

	public String getBusinessName() {
		return this.mBusinessName;
	}

	public Contact getContact() {
		return this.mContact;
	}
	
}

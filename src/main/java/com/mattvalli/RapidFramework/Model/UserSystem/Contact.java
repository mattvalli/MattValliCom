package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.ContactDao;

@Entity
@Table(name = ContactDao.DATABASE + "." + ContactDao.TABLE)
public class Contact extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_TYPE_CONTACT)
	private ContactType 	mType;
	
	@OneToOne(mappedBy ="person")
	@JoinColumn(name = ContactDao.JOIN_PERSON)
	private Person			mPerson;
	
	@Column(name = ContactDao.COLUMN_EMAIL_PRIMARY)
	private String			mEmailPrimary;
	
	@Column(name = ContactDao.COLUMN_EMAIL_SECONDARY)
	private String			mEmailSecondary;
	
	@Column(name = ContactDao.COLUMN_EMAIL_BUSINESS_PRIMARY)
	private String			mEmailBusinessPrimary;
	
	@Column(name = ContactDao.COLUMN_EMAIL_BUSINESS_SECONDARY)
	private String			mEmailBusinessSecondary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_PHONE_HOME)
	private PhoneNumber 	mHomePhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_PHONE_MOBILE_PRIMARY)
	private PhoneNumber 	mMobilePrimary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_PHONE_MOBILE_SECONDARY)
	private PhoneNumber 	mMobileSecondary;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_PHONE_WORK)
	private PhoneNumber 	mWorkPhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_PHONE_WORK_MOBILE)
	private PhoneNumber 	mWorkMobile;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_ADDRESS_HOME)
	private Address 		mHomeAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_ADDRESS_PERMINENT)
	private Address 		mPerminentAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_ADDRESS_MAILING)
	private Address 		mMailingAddress;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = ContactDao.JOIN_ADDRESS_WORK)
	private Address			mWorkAddress;
	
	
	// CONSTRUCTORS
	public Contact() {
		// Empty
	}

	public Contact(	Integer			id,
					String			displayName,
					ContactType		type,
					Person			person,
					String			primaryEmail,
					String			secondaryEmail,
					String			workPrimaryEmail,
					String			workSecondaryEmail,
					PhoneNumber		homePhone,
					PhoneNumber		primaryMobile,
					PhoneNumber		secondaryMobile,
					PhoneNumber		workPhone,
					PhoneNumber		workMobile,
					Address			homeAddress,
					Address			perminentAddress,
					Address			mailingAddress,
					Address			workAddress				) {
		// Set Properties
		this.mId	= id;
		this.mDisplayName				= displayName;
		this.mType						= type;
		this.mPerson					= person;
		this.mEmailPrimary				= primaryEmail;
		this.mEmailSecondary			= secondaryEmail;
		this.mEmailBusinessPrimary		= workPrimaryEmail;
		this.mEmailBusinessSecondary	= workSecondaryEmail;
		this.mHomePhone					= homePhone;
		this.mMobilePrimary				= primaryMobile;
		this.mMobileSecondary			= secondaryMobile;
		this.mWorkPhone					= workPhone;
		this.mWorkMobile				= workMobile;
		this.mHomeAddress				= homeAddress;
		this.mPerminentAddress			= perminentAddress;
		this.mMailingAddress			= mailingAddress;
		this.mWorkAddress				= workAddress;
	}
	
	public Contact(	ContactType		type,
					Person			person,
					String			primaryEmail,
					String			secondaryEmail,
					String			workPrimaryEmail,
					String			workSecondaryEmail,
					PhoneNumber		homePhone,
					PhoneNumber		primaryMobile,
					PhoneNumber		secondaryMobile,
					PhoneNumber		work,
					PhoneNumber		workMobile,
					Address			homeAddress,
					Address			perminent,
					Address			mailing,
					Address			workAddress				) {
		this(	AbstractModelClass.INVALID_ID,
				person.getFullName(),
				type,
				person,
				primaryEmail,
				secondaryEmail,
				workPrimaryEmail,
				workSecondaryEmail,
				homePhone,
				primaryMobile,
				secondaryMobile,
				work,
				workMobile,
				homeAddress,
				perminent,
				mailing,
				workAddress		);
	}
					
					
					
					
	


	
	
	// OVERRIDES
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// SETTERS
	public void setPerson(Person person) {
		mPerson = person;
	}


	public void setEmailPrimary(String emailPrimary) {
		mEmailPrimary = emailPrimary;
	}


	public void setEmailSecondary(String emailSecondary) {
		mEmailSecondary = emailSecondary;
	}


	public void setEmailBusinessPrimary(String emailBusinessPrimary) {
		mEmailBusinessPrimary = emailBusinessPrimary;
	}


	public void setEmailBusinessSecondary(String emailBusinessSecondary) {
		mEmailBusinessSecondary = emailBusinessSecondary;
	}


	public void setHomePhone(PhoneNumber home) {
		mHomePhone = home;
	}


	public void setMobilePrimary(PhoneNumber mobilePrimary) {
		mMobilePrimary = mobilePrimary;
	}


	public void setMobileSecondary(PhoneNumber mobileSecondary) {
		mMobileSecondary = mobileSecondary;
	}


	public void setWorkPhone(PhoneNumber workOffice) {
		mWorkPhone = workOffice;
	}


	public void setWorkMobile(PhoneNumber workMobile) {
		mWorkMobile = workMobile;
	}


	public void setHomeAddress(Address homeAddress) {
		mHomeAddress = homeAddress;
	}


	public void setPerminentAddress(Address perminentAddress) {
		mPerminentAddress = perminentAddress;
	}


	public void setMailingAddress(Address mailingAddress) {
		mMailingAddress = mailingAddress;
	}


	public void setWorkAddress(Address workAddress) {
		mWorkAddress = workAddress;
	}
	
	// GETTERS
	public Person getPerson() {
		return mPerson;
	}

	public String getEmailPrimary() {
		return mEmailPrimary;
	}

	public String getEmailSecondary() {
		return mEmailSecondary;
	}

	public String getEmailBusinessPrimary() {
		return mEmailBusinessPrimary;
	}

	public String getEmailBusinessSecondary() {
		return mEmailBusinessSecondary;
	}

	public PhoneNumber getHomePhone() {
		return mHomePhone;
	}

	public PhoneNumber getMobilePrimary() {
		return mMobilePrimary;
	}

	public PhoneNumber getMobileSecondary() {
		return mMobileSecondary;
	}

	public PhoneNumber getWorkPhone() {
		return mWorkPhone;
	}

	public PhoneNumber getWorkMobile() {
		return mWorkMobile;
	}

	public Address getHomeAddress() {
		return mHomeAddress;
	}

	public Address getPerminentAddress() {
		return mPerminentAddress;
	}

	public Address getMailingAddress() {
		return mMailingAddress;
	}

	public Address getWorkAddress() {
		return mWorkAddress;
	}
}

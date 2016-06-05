package com.mattvalli.RapidFramework.UserSystem.dao;

public interface ContactDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL						= "Contact";
		// Database
		public static final String DATABASE							= "USER_SYSTEM";
		public static final String TABLE							= "CONTACT";
		// Columns
		public static final String JOIN_TYPE_CONTACT				= "fk_type_contact";
		public static final String JOIN_PERSON						= "fk_person";
		public static final String COLUMN_EMAIL_PRIMARY				= "email_primary";
		public static final String COLUMN_EMAIL_SECONDARY			= "email_secondary";
		public static final String COLUMN_EMAIL_BUSINESS_PRIMARY	= "email_business_primary";
		public static final String COLUMN_EMAIL_BUSINESS_SECONDARY	= "email_business_secondary";
		public static final String JOIN_PHONE_HOME					= "fk_phone_home";
		public static final String JOIN_PHONE_MOBILE_PRIMARY 		= "fk_phone_mobile_primary";
		public static final String JOIN_PHONE_MOBILE_SECONDARY		= "fk_phone_mobile_secondary";
		public static final String JOIN_PHONE_WORK_MOBILE			= "fk_phone_work_mobile";
		public static final String JOIN_PHONE_WORK					= "fk_phone_work";
		public static final String JOIN_ADDRESS_HOME				= "fk_address_home";
		public static final String JOIN_ADDRESS_PERMINENT			= "fk_address_perminent";
		public static final String JOIN_ADDRESS_MAILING				= "fk_address_mailing";
		public static final String JOIN_ADDRESS_WORK				= "fk_address_work";
		
		
}

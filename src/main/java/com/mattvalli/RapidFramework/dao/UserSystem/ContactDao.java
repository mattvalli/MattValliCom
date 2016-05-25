package com.mattvalli.RapidFramework.dao.UserSystem;

public interface ContactDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL						= "Contact";
		// Database
		public static final String DATABASE							= "USER_SYSTEM";
		public static final String TABLE							= "CONTACT";
		// Columns
		public static final String COLUMN_PHONE_HOME				= "fk_phone_home";
		public static final String COLUMN_PHONE_MOBILE_PRIMARY 		= "fk_phone_mobile_primary";
		public static final String COLUMN_PHONE_MOBILE_SECONDARY	= "fk_phone_mobile_secondary";
		public static final String COLUMN_PHONE_WORK_MOBILE			= "fk_phone_work_mobile";
		public static final String COLUMN_PHONE_WORK_OFFICE			= "fk_phone_work_office";
		public static final String COLUMN_ADDRESS_HOME				= "address_home";
		public static final String COLUMN_ADDRESS_PERMINENT			= "address_perminent";
		public static final String COLUMN_ADDRESS_MAILING			= "address_mailing";
		
		
}

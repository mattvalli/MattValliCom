package com.mattvalli.RapidFramework.dao.UserSystem;

public interface AddressDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 	= "Address";
		// Database
		public static final String DATABASE		= "USER_SYSTEM";
		public static final String TABLE		= "ADDRESS";
		// Columns
		public static final String COLUMN_ID				= "id";
		public static final String COLUMN_STREET_NUMBER 	= "street_number";
		public static final String COLUMN_STREET			= "street";
		public static final String COLUMN_UNIT				= "unit";
		public static final String COLUMN_BUILDING_NUMBER	= "building_number";
		public static final String COLUMN_BUILDING_FLOOR	= "building_floor";
		public static final String COLUMN_COMPLEX			= "complex";
		public static final String COLUMN_CITY				= "city";
		public static final String COLUMN_STATE				= "state";
		public static final String COLUMN_POSTAL_CODE		= "postal_code";
		public static final String COLUMN_COUNTRY			= "country";
		public static final String COLUMN_ADDRESS_TYPE		= "fk_type_address";
		public static final String COLUMN_NAME_BUSINESS		= "name_business";
		public static final String COLUMN_CONTACT			= "fk_contact";
		
}
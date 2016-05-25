package com.mattvalli.RapidFramework.dao.UserSystem;

public interface PhoneNumberDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL = "PhoneNumber";
		// Database
		public static final String DATABASE		= "USER_SYSTEM";
		public static final String TABLE		= "Phone";
		// Columns
		public static final String COLUMN_CODE_COUNTRY 	= "code_country";
		public static final String COLUMN_CODE_AREA		= "code_area";
		public static final String COLUMN_PREFIX		= "prefix";
		public static final String COLUMN_POSTFIX		= "postfix";
		public static final String COLUMN_EXTENSION		= "extension";
		public static final String JOIN_ROUTE_MAP		= "fk_phone_route_map";
		public static final String JOIN_COUNTRY			= "fk_country";
}

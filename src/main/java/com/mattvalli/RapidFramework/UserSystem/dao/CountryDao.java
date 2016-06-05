package com.mattvalli.RapidFramework.UserSystem.dao;

public interface CountryDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL  				= "Country";
		// Database
		public static final String DATABASE						= "USER_SYSTEM";
		public static final String TABLE						= "COUNTRY";
		// Columns
		public static final String COLUMN_ENUM_COUNTRY			= "enum_value";
		public static final String COLUMN_PHONE_COUNRTY_CODE 	= "phone_code_country";
		public static final String COLUMN_ABBREVIATION			= "abbreviation";
}

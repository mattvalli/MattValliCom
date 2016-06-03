package com.mattvalli.RapidFramework.dao.UserSystem;

public interface PersonDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL			= "Person";
		// Database
		public static final String DATABASE				= "USER_SYSTEM";
		public static final String TABLE				= "PERSON";
		// Columns
		public static final String COLUMN_NAME_FIRST	= "name_first";
		public static final String COLUMN_NAME_LAST		= "name_last";
		public static final String COLUMN_DOB			= "date_birth";
		public static final String JOIN_CONTAINER_NAME	= "fk_container_name";
		public static final String JOIN_GENDER 			= "fk_gender";
		public static final String JOIN_CONTACT			= "fk_contact";

		// Formatters
		public static final String DATE_FORMAT		= "yyyy-MM-dd";
}

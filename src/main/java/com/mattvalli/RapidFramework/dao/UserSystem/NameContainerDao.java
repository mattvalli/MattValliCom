package com.mattvalli.RapidFramework.dao.UserSystem;

public interface NameContainerDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL			= "NameContainer";
		// Database
		public static final String DATABASE				= "USER_SYSTEM";
		public static final String TABLE				= "CONTAINER_NAME";
		// Columns
		public static final String COLUMN_PREFIX 		= "name_prefix";
		public static final String COLUMN_POSTFIX		= "name_postfix";
		// Join
		public static final String JOIN_TABLE			= "ASSOCIATE_NAME";
		public static final String JOIN_NAME			= "fk_name";
		public static final String JOIN_CONTAINER_NAME	= "fk_container_name";
		
		
}

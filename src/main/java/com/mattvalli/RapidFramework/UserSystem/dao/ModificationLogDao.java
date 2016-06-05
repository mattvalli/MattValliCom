package com.mattvalli.RapidFramework.UserSystem.dao;

public interface ModificationLogDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL  = "ModificationLog";
		// Database
		public static final String DATABASE		= "USER_SYSTEM";
		public static final String TABLE		= "LOG_MODIFICATION";
		// Columns
		public static final String COLUMN_ID			= "id";
		public static final String COLUMN_TABLE_NAME	= "table_name";
		public static final String COLUMN_RECORD_ID		= "fk_record_id";
		public static final String COLUMN_VERSION		= "version";
		public static final String COLUMN_USER_ID		= "fk_user_id";
		public static final String COLUMN_DATE_CREATED	= "date_created";

		// Formatters
		public static final String DATE_FORMAT = "yyyy-MM-dd hh:mm:ss";
}

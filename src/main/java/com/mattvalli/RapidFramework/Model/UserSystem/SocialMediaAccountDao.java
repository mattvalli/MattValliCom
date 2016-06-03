package com.mattvalli.RapidFramework.Model.UserSystem;

public interface SocialMediaAccountDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 				= "SocialMediaAccount";
		// Database
		public static final String DATABASE 				= "USER_SYSTEM";
		public static final String TABLE					= "SOCIAL_MEDIA_ACCOUNT";
		// Column
		public static final String COLUMN_ACCOUNT_OWNER		= "fk_person";
		public static final String COLUMN_ACCOUNT_PROVIDER 	= "account_provider";
		public static final String COLUMN_USERNAME			= "username";
		public static final String COLUMN_CREDENTIALS		= "credentials";
}

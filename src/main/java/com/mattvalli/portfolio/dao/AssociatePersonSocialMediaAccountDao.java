package com.mattvalli.portfolio.dao;

public interface AssociatePersonSocialMediaAccountDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL					= "AssociatePersonSocialMediaAccount";
		// Database
		public static final String DATABASE 					= "PORTFOLIO";
		public static final String TABLE						= "ASSOCIATE_PERSON_SOCIAL_MEDIA_ACCOUNT";
		// Columns
		public static final String JOIN_PERSON					= "fk_person";
		public static final String JOIN_SOCIAL_MEDIA_ACCOUNT	= "fk_social_media_account";
}

package com.mattvalli.portfolio.dao;

public interface PortfolioDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL					= "Portfolio";
		// Database
		public static final String DATABASE 					= "PORTFOLIO";
		public static final String TABLE						= "PORTFOLIO";
		// Columns
		public static final String COLUMN_TITLE					= "title";
		public static final String JOIN_PERSON 					= "fk_person";
		public static final String JOIN_SUBJECT					= "fk_subject";
		public static final String JOIN_EXPERIENCE				= "fk_experience";
		public static final String JOIN_PROJECT					= "fk_project";
		public static final String JOIN_SKILL					= "fk_skill";
		public static final String JOIN_SOCIAL_MEDIA_ACCOUNT	= "fk_social_media_account";
		public static final String JOIN_BOOK					= "fk_book";
		public static final String JOIN_RESOURCE				= "fk_resource";
		public static final String JOIN_TUTORIAL				= "fk_tutorial";
		
}

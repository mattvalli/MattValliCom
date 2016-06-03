package com.mattvalli.portfolio.dao;

public interface TutorialDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL		= "Tutorial";
		// Database
		public static final String DATABASE			= "PORTFOLIO";
		public static final String TABLE			= "TUTORIAL";
		// Columns
		public static final String COLUMN_SUBTITLE 	= "subtitle";
		public static final String COLUMN_CONTENT	= "content";
		public static final String JOIN_SUBJECT		= "fk_subject";
		
	
}

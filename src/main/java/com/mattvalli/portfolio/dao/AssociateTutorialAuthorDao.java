package com.mattvalli.portfolio.dao;

public interface AssociateTutorialAuthorDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL = "AssociateTutorialAuthor";
		// Database
		public static final String DATABASE			= "PORTFOLIO";
		public static final String TABLE			= "ASSOCIATE_TUTORIAL_AUTHOR";
		// Columns
		public static final String JOIN_AUTHOR		= "fk_person";
		public static final String JOIN_TUTORIAL	= "fk_tutorial";
}

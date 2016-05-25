package com.mattvalli.portfolio.dao;

public interface AuthorDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 					= "Author";
		// Database
		public static final String DATABASE 					= "PORTFOLIO";
		public static final String TABLE						= "AUTHOR";
		// Columns
		public static final String JOIN_PERSON					= "fk_person";
		public static final String JOIN_ASSOCIATE_BOOK_AUTHOR	= "fk_book_author";
}

package com.mattvalli.portfolio.dao;

public interface AssociateBookAuthorDao {
	public  static final String CLASSNAME_MODEL		= "BookAuthor";
		// Database
		public static final String DATABASE			= "PORTFOLIO";
		public static final String TABLE			= "ASSOCIATE_BOOK_AUTHOR";
		// Columns
		public static final String COLUMN_ID		= "id";
		public static final String COLUMN_BOOK 		= "fk_book";
		public static final String COLUMN_AUTHOR	= "fk_author";
}

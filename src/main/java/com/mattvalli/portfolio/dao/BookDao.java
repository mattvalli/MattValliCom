package com.mattvalli.portfolio.dao;

public interface BookDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL = "Book";
		// Database
		public static final String DATABASE				= "PORTFOLIO";
		public static final String TABLE				= "BOOK";
		public static final String COLUMN_TITLE 		= "title";
		public static final String COLUMN_SUBTITLE		= "subtitle";
		public static final String COLUMN_ISBN			= "isbn";
		public static final String COLUMN_DESC			= "description";
		public static final String COLUMN_COVER_IMG		= "fk_url_cover_img";
}

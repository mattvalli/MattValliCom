package com.mattvalli.portfolio.dao;

public interface AssociateBookChapterDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 			= "AssociateBookChapter";
		// Database
		public static final String DATABASE 			= "PORTFOLIO";
		public static final String TABLE				= "ASSOCIATE_BOOK_CHAPTER";
		// Columns
		public static final String COLUMN_ID			= "id";
		public static final String COLUMN_ORDER_SORT 	= "order_sort";
		public static final String JOIN_BOOK			= "fk_book";
		public static final String JOIN_CHAPTER			= "fk_chapter";
		
}

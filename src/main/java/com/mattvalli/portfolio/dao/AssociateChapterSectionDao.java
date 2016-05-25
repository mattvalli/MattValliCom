package com.mattvalli.portfolio.dao;

public interface AssociateChapterSectionDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL = "AssociateChapterSection";
		// Database
		public static final String DATABASE 	= "PORTFOLIO";
		public static final String TABLE		= "ASSOCIATE_CHAPTER_SECTION";
		// Columns
		public static final String COLUMN_ID	= "id";
		public static final String COLUMN_ORDER_SORT	= "order_sort";
		public static final String JOIN_CHAPTER			= "fk_chapter";
		public static final String JOIN_SECTION			= "fk_section";
}

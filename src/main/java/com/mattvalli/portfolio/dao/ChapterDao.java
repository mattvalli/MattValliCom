package com.mattvalli.portfolio.dao;

public interface ChapterDao {
	// CONSTANT
	public static final String CLASSNAME_MODEL 						= "Chapter";
		// Database
		public static final String DATABASE							= "PORTFOLIO";
		public static final String TABLE							= "CHAPTER";
		// Columns
		public static final String COLUMN_SUBTITLE 					= "subtitle";
		public static final String JOIN_ASSOCIATE_CHAPTER_SECTION	= "fk_section";
		
}

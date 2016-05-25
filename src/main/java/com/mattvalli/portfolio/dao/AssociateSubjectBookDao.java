package com.mattvalli.portfolio.dao;

public interface AssociateSubjectBookDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL					= "AssociateSubjectBook";
		// Database
		public static final String DATABASE 					= "PORTFOLIO";
		public static final String TABLE						= "ASSOCIATE_SUBJECT_BOOK";
		// Columns
		public static final String JOIN_SUBJECT					= "fk_subject";
		public static final String JOIN_BOOK					= "fk_book";
}

package com.mattvalli.portfolio.dao;

public interface InstitutionDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 				= "Institution";
		// Database
		public static final String DATABASE 				= "PORTFOLIO";
		public static final String TABLE					= "INSTITUTION";
		// Columns
		public static final String COLUMN_NAME				= "name";
		public static final String JOIN_TYPE_INSTITUTION 	= "fk_type_institution";
		public static final String JOIN_ADDRESS				= "fk_address";
		public static final String JOIN_URL					= "fk_url";
}

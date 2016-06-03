package com.mattvalli.portfolio.dao;

public interface ResourceDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 			= "Resource";
		// Database
		public static final String DATABASE				= "PORTFOLIO";
		public static final String TABLE				= "RESOURCE";
		// Column
		public static final String COLUMN_URL			= "url";
		public static final String JOIN_TYPE_RESOURCE	= "fk_type_resource";
}

package com.mattvalli.portfolio.dao;

public interface ExperienceDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL = "Experience";
		// Database
		public static final String DATABASE				= "PORTFOLIO";
		public static final String TABLE				= "EXPERIENCE";
		// Columns
		public static final String COLUMN_JOB_TITLE		= "job_title";
		public static final String COLUMN_DESC			= "description";
		public static final String COLUMN_DATE_START	= "date_start";
		public static final String COLUMN_DATE_END		= "date_end";
		public static final String JOIN_TYPE_EXPERIENCE	= "fk_type_experience";
		public static final String JOIN_BUSINESS		= "fk_business";
		// Formatters
		public static final String DATE_FORMAT			= "yyyy-MM-dd";
}

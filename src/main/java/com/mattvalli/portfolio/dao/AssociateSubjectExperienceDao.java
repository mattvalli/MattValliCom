package com.mattvalli.portfolio.dao;

public interface AssociateSubjectExperienceDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 	= "AssociateSubjectExperience";
		// Database
		public static final String DATABASE 	= "PORTFOLIO";
		public static final String TABLE		= "ASSOCIATE_SUBJECT_EXPERIENCE";
		// Columns
		public static final String JOIN_SUBJECT		= "fk_subject";
		public static final String JOIN_EXPERIENCE	= "fk_experience";
}

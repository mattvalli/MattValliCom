package com.mattvalli.portfolio.dao;

public interface AssociateSubjectSkill {
	// CONSTANTS
		public static final String CLASSNAME_MODEL 	= "AssociateSubjectSkill";
			// Database
			public static final String DATABASE 	= "PORTFOLIO";
			public static final String TABLE		= "ASSOCIATE_SUBJECT_SKILL";
			// Columns
			public static final String JOIN_SUBJECT	= "fk_subject";
			public static final String JOIN_SKILL	= "fk_skill";
}

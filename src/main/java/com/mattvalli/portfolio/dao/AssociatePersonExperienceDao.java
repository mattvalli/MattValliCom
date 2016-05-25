package com.mattvalli.portfolio.dao;

import com.mattvalli.RapidFramework.dao.AbstractInterfaceDao;

public interface AssociatePersonExperienceDao extends AbstractInterfaceDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 		= "AssociatePersonExperience";
		// Database
		public static final String DATABASE			= "PORTFOLIO";
		public static final String TABLE			= "ASSOCIATE_PERSON_EXPERIENCE";
		// Columns
		public static final String JOIN_PERSON		= "fk_person";
		public static final String JOIN_EXPERIENCE	= "fk_experience";
		public static final String JOIN_SUBJECT		= "fk_subject";
}

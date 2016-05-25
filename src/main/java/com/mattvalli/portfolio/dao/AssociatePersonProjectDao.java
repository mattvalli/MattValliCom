package com.mattvalli.portfolio.dao;

public interface AssociatePersonProjectDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 	= "AssociatePersonProject";
		// Database
		public static final String DATABASE 	= "PORTFOLIO";
		public static final String TABLE		= "ASSOCIATE_PERSON_PROJECT";
		// Columns
		public static final String JOIN_PERSON 	= "fk_person";
		public static final String JOIN_PROJECT	= "fk_project";
		public static final String JOIN_SUBJECT	= "fk_subject";
}

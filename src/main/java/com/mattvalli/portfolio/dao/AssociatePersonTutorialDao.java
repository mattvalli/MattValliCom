package com.mattvalli.portfolio.dao;

public interface AssociatePersonTutorialDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 	= "AssociatePersonTutorial";
	// Database
	public static final String DATABASE 	= "PORTFOLIO";
	public static final String TABLE		= "ASSOCIATE_PERSON_TUTORIAL";
	// Columns
	public static final String JOIN_PERSON	= "fk_person";
	public static final String JOIN_SKILL	= "fk_tutorial";
}

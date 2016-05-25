package com.mattvalli.portfolio.dao;

public interface AssociatePersonSkillDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL 	= "AssociatePersonSkill";
		// Database
		public static final String DATABASE 	= "PORTFOLIO";
		public static final String TABLE		= "ASSOCIATE_PERSON_SKILL";
		// Columns
		public static final String JOIN_PERSON	= "fk_person";
		public static final String JOIN_SKILL	= "fk_skill";
}

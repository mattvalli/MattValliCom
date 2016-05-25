package com.mattvalli.RapidFramework.Model.UserSystem;

import java.util.LinkedList;

public class User {
	// CONSTANTS
	
	// PROPERTIES
	private Person					mPerson;
	private LinkedList<Role>		mRoles;
	private LinkedList<UserGroup>	mUserGroups;
	private String					mEncryptionSalt;
	private String					mEncryptedPassword;
	
	// CONSTRUCTORS
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("USER OBJECT" + "\n");
		
		output.append("Person: " + this.mPerson.getFullName() + "\n");
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// SETTERS
	
	// GETTERS
	
}

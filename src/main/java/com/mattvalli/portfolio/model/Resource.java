package com.mattvalli.portfolio.model;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;

public class Resource extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	
	// CONSTRUCTORS
	public Resource() {
		
	}
	
	public Resource(	Integer id,
						String displayName	) {
		// Set all Properties
		mId 				= id;
		mDisplayName 		= displayName;
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("RESOURCE OBJECT" + "\n");
		
		output.append("ID: " 			+ Integer.toString(mId) 	+ "\n");
		output.append("Display Name: " 	+ mDisplayName 				+ "\n");
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	public boolean equals(Object o) {
		if ( ! (o instanceof Resource) ) return false;
		
		// Object must be of type Resource
		Resource r = (Resource) o;
		
		// Equality conditions
		// CODE FOR DATABASE EQUALITY (Should be moved to DAO Object in the future to reduce data entry redundancies
				// If the Display Names are the same, the IDs are not equal, and the ID isn't the INVALID_ID Constant:
				// - then there is a repetitive entry in the Database
				if ( this.mId != r.getId() || this.mId != AbstractModelClass.INVALID_ID ) return false;
		
		return true;
	}
	
	// METHODS
	
	// SETTERS
	
	// GETTERS
}

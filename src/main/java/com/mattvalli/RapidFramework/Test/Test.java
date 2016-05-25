package com.mattvalli.RapidFramework.Test;

public abstract class Test {
	// CONSTANTS
	
	// PROPERTIES
	protected String mTestName;
	protected String mDescription;
	
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("ABSTRACT TEST" + "\n");
		
		output.append("Test Name: " + mTestName + "\n");
		output.append("Description: " + "\n");
		output.append(mDescription + "\n");
		
		return output.toString();
	}
	
	// METHODS
	
	// SETTERS
	public void setTestName(String testName) {
		mTestName = testName;
	}

	public void setDescription(String description) {
		mDescription = description;
	}
	
	// GETTERS
	public String getTestName() {
		return mTestName;
	}

	public String getDescription() {
		return mDescription;
	}
	
	
}

package com.mattvalli.portfolio.model;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;

public class Subject extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	private String 						mDescription;
	private HashMap<Integer,Resource>	mResources;
	private HashMap<Integer,URL>		mDocumentation;
	private HashMap<Integer,Tutorial> 	mTutorials;
	private HashMap<Integer,Project>	mProjects;
	
	private LinkedList<Integer> 		mOrderResources;
	private LinkedList<Integer> 		mOrderDocumentation;
	private LinkedList<Integer> 		mOrderTutorials;
	private LinkedList<Integer> 		mOrderProjects;
	
	// CONSTRUCTORS
	public Subject() {
		// Only set the ID as INVALID_ID
		mId = AbstractModelClass.INVALID_ID;
	}
	
	public Subject(		Integer	id,
						String	displayName,
						String	description,
						HashMap<Integer,Resource>	resources,
						HashMap<Integer,URL> documentation,
						HashMap<Integer,Tutorial>	tutorials,
						HashMap<Integer,Project>	projects,
						LinkedList<Integer>			orderResources,
						LinkedList<Integer>			orderDocumentation,
						LinkedList<Integer>			orderTutorials,
						LinkedList<Integer>			orderProjects			) {
		// Set Properties
		mId					=	id;
		mDisplayName		=	displayName;
		mDescription		=	description;
		mResources			=	resources;
		mDocumentation		=	documentation;
		mTutorials			=	tutorials;
		mProjects			=	projects;
		mOrderResources		=	orderResources;
		mOrderDocumentation	=	orderDocumentation;
		mOrderTutorials		=	orderTutorials;
		mOrderProjects		=	orderProjects;
}
	
	public Subject(		Integer	id,
						String	displayName,
						String	description,
						HashMap<Integer,Resource>	resources,
						HashMap<Integer,URL> documentation,
						HashMap<Integer,Tutorial>	tutorials,
						HashMap<Integer,Project>	projects		) {
		// Pass to main constructor
		this(	id,
				displayName,
				description,
				resources,
				documentation,
				tutorials,
				projects,
				null,
				null,
				null,
				null			);
	}
	
	public Subject(		Integer	id,
						String	displayName,
						String	description,
						LinkedList<Integer>	orderResources,
						LinkedList<Integer> orderDocumentation,
						LinkedList<Integer>	orderTutorials,
						LinkedList<Integer>	orderProjects		) {
		// Pass to main constructor
		this(	id,
				displayName,
				description,
				null,
				null,
				null,
				null,
				orderResources,
				orderDocumentation,
				orderTutorials,
				orderProjects		);
	}
	
	public Subject(		Integer	id,
						String	displayName,
						String	description		) {
		// Pass to main constructor
		this(	id,
				displayName,
				description,
				null,
				null,
				null,
				null,
				null,
				null,
				null,
				null		);
	}

	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output	=	new StringBuilder("SUBJECT OBJECT" + "\n");
		
		output.append("ID: " + mId + "\n");
		output.append("Display Name: " + mDisplayName + "\n");
		output.append("Description:" + "\n");
		output.append(mDescription + "\n");
		
		// Loop through the Order of Resources and Select the DisplayNames of these objects
		if (mResources != null) output.append("Resource Count: " + Integer.toString(mResources.size()));
		else 					output.append("Resource Count: NULL");
		
		// Loop through the Order of Documentation and Select the DisplayNames of these objects
		if (mDocumentation != null) output.append("Documentation Count: " + Integer.toString(mDocumentation.size()));
		else						output.append("Documentation Count: NULL");
		
		// Loop through the Order of Tutorials and Select the DisplayNames of these objects
		if (mTutorials != null) output.append("Tutorial Count: " + Integer.toString(mTutorials.size()));
		else					output.append("Tutorial Count: NULL");
		
		// Loop through the Order of Projects and Select the DisplayNames of these objects
		if (mProjects != null)	output.append("Project Count: " + Integer.toString(mProjects.size()));
		else					output.append("Project Count: NULL");
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	public boolean equals(Object o) {
		if ( ! (o instanceof Subject) ) return false;
		
		// Object must be a Subject Object
		Subject s = (Subject) o;
		
		// Check Equality conditions
		// Display Name determines Subjects' equality
		if ( this.mDisplayName != s.getDisplayName() ) return false;
		
		// CODE FOR DATABASE EQUALITY (Should be moved to DAO Object in the future to reduce data entry redundancies
		// If the Display Names are the same, the IDs are not equal, and the ID isn't the INVALID_ID Constant:
		// - then there is a repetitive entry in the Database
		//if ( this.mId != s.getId() || this.mId != AbstractModelClass.INVALID_ID ) return false;
		
		// If none of the if statements passed, then the objects are equal regardless of Reference
		return true;
	}
	
	// METHODS
	
	
	// SETTERS
	public void setDescription(String description) {
		mDescription = description;
	}

	public void setResources(HashMap<Integer, Resource> resources) {
		mResources = resources;
	}

	public void setDocumentation(HashMap<Integer, URL> documentation) {
		mDocumentation = documentation;
	}

	public void setTutorials(HashMap<Integer, Tutorial> tutorials) {
		mTutorials = tutorials;
	}

	public void setProjects(HashMap<Integer, Project> projects) {
		mProjects = projects;
	}

	public void setOrderResources(LinkedList<Integer> orderResources) {
		mOrderResources = orderResources;
	}

	public void setOrderDocumentation(LinkedList<Integer> orderDocumentation) {
		mOrderDocumentation = orderDocumentation;
	}

	public void setOrderTutorials(LinkedList<Integer> orderTutorials) {
		mOrderTutorials = orderTutorials;
	}

	public void setOrderProjects(LinkedList<Integer> orderProjects) {
		mOrderProjects = orderProjects;
	}
	
	// GETTERS
	public String getDescription() {
		return mDescription;
	}

	public HashMap<Integer, Resource> getResources() {
		return mResources;
	}

	public HashMap<Integer, URL> getDocumentation() {
		return mDocumentation;
	}

	public HashMap<Integer, Tutorial> getTutorials() {
		return mTutorials;
	}

	public HashMap<Integer, Project> getProjects() {
		return mProjects;
	}

	public LinkedList<Integer> getOrderResources() {
		return mOrderResources;
	}

	public LinkedList<Integer> getOrderDocumentation() {
		return mOrderDocumentation;
	}

	public LinkedList<Integer> getOrderTutorials() {
		return mOrderTutorials;
	}

	public LinkedList<Integer> getOrderProjects() {
		return mOrderProjects;
	}
}

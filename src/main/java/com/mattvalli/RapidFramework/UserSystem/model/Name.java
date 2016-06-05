package com.mattvalli.RapidFramework.UserSystem.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.UserSystem.dao.NameContainerDao;

@Entity
@Table(name = NameContainerDao.DATABASE + "." + NameContainerDao.TABLE)
public class Name extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name = NameContainerDao.COLUMN_PREFIX)
	private String 				mPrefix;
	
	@Column(name = NameContainerDao.COLUMN_POSTFIX)
	private String				mPostfix;
	
	
	@ElementCollection
	@CollectionTable(	name 				= NameContainerDao.JOIN_TABLE, 
						joinColumns 		= @JoinColumn(name = NameContainerDao.JOIN_CONTAINER_NAME))
	private List<String> 	mNames;
	
	
	// CONSTRUCTORS
	public Name() {
		mId = AbstractModelClass.INVALID_ID;
	}
	
	public Name(Integer id, List<String> names, String prefix, String postfix) {
		mId 			= id;
		mNames 			= names;
		mPrefix 		= prefix;
		mPostfix		= postfix;
		
		mDisplayName	= this.getName();
	}
	
	public Name(List<String> names, String prefix, String postfix) {
		this(AbstractModelClass.INVALID_ID, names, prefix, postfix);
	}
	
	public Name(List<String> names) {
		this(AbstractModelClass.INVALID_ID, names, "", "");
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("NAME CONTAINER OBJECT" + "\n");
		
		output.append("Full Name: " + this.getFullName());
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// UTILITY METHODS
	/*
	public static List<Name> stringListToNameList(List<String> asStrings) {
		// Create an new ArrayList<Names>
		List<Name> asNameObjects = new ArrayList<Name>();
		
		// Loop through the list of Strings converting them to Name objects
		Iterator<String> iterator = asStrings.iterator();
		while(	iterator.hasNext() 	) {
			// Use the Name(String) Constructor to Create a Name Instance
			// Add the Name to the List of Names
			asNameObjects.add(		new Name(	iterator.next()	)		);
		}
		
		return asNameObjects;
	}
	*/
	
	// SETTERS
	public void setFirstName(String firstName) {
		mNames.set(0, firstName);
	}

	public void setName(int index, String name) {
		try {
			mNames.set(index, name);
		} catch (Exception e) {
			System.err.println("It is likely that the index is 'Out of Bounds', meaning the user does not have that many names" + "\n");
			System.err.println("Remember that ArrayList in Java is Zero-Based!" + "\n");
			e.printStackTrace();
		}
	}
	
	public void setNames(List<String> givenNames) {
		mNames = givenNames;
	}

	public void setLastName(String lastName) {
		mNames.set(mNames.size() - 1, lastName);
	}

	public void setPrefix(String prefix) {
		mPrefix = prefix;
	}
	
	public void setPostFix(String postfix) {
		mPostfix = postfix;
	}
	
	// GETTERS
	public String getFirstName() {
		return mNames.get(0);
	}

	public String getName(int index) {
		// If the index is equal to or greater than the array size, we are out of bounds
		if (index >= mNames.size()) return null;
		return mNames.get(index);
	}
	
	public List<String> getNames() {
		return mNames;
	}
	
	public String getNamesAsString() {
		StringBuilder output = new StringBuilder();
		
		Iterator<String> i = mNames.iterator();
		while (i.hasNext()) {
			output.append(i.next());
			if (i.hasNext()) output.append(" ");
		}
		
		return output.toString();
	}
	
	public String getMiddleNamesAsString() {
		StringBuilder output = new StringBuilder();
		
		Iterator<String> i = mNames.iterator();
		String currentName = null;
		
		// Throw Away the first name in the Data Structure
		i.next();
		
		// Loop through remaining names
		while (i.hasNext()) {
			// Get the next name
			currentName = i.next();
			
			// Only append to output if there still are names left
			// else the currentName is the last name and we can exit loop
			if (i.hasNext()) 	output.append(currentName + " ");
			else 				break;
		}
		
		// Cast to String an remove leading/trailing Whitespace
		return output.toString().trim();
	}

	public String getLastName() {
		return mNames.get(mNames.size() - 1);
	}
	
	public String getName() {
		StringBuilder output = new StringBuilder();
		
		if (mPrefix != null || !mPrefix.equals("") ) output.append(mPrefix + " ");
		
		// Only Append First and Last Names
		output.append(mNames.get(0));
		output.append(" " + mNames.get(mNames.size() - 1));
		
		if (mPostfix != null || !mPostfix.equals("")) output.append(" " + mPostfix);
		
		return output.toString();
	}
	
	public String getFullName() {
		StringBuilder output = new StringBuilder();
		
		if (mPrefix 	!= null 	|| 	!mPrefix.equals("") 	) output.append(mPrefix + " ");
		if (mNames		!= null 	|| 	mNames.size() > 0		) output.append(this.getNamesAsString());
		if (mPostfix 	!= null 	|| 	!mPostfix.equals("")	) output.append(" " + mPostfix);
		
		return output.toString();
	}
}

package com.mattvalli.RapidFramework.Model.UserSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.NameContainerDao;

@Entity
@Table(name = NameContainerDao.DATABASE + "." + NameContainerDao.TABLE)
public class NameContainer extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name = NameContainerDao.COLUMN_PREFIX)
	private String 				mPrefix;
	
	@Column(name = NameContainerDao.COLUMN_POSTFIX)
	private String				mPostfix;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(	name = NameContainerDao.JOIN_TABLE, 
				joinColumns = @JoinColumn(name = NameContainerDao.JOIN_CONTAINER_NAME), 
				inverseJoinColumns = @JoinColumn(name = NameContainerDao.JOIN_NAME)		)
	private List<String> 	mGivenNames;
	
	
	// CONSTRUCTORS
	public NameContainer() {
		mId = AbstractModelClass.INVALID_ID;
	}
	
	public NameContainer(Integer id, List<String> names, String prefix, String postfix) {
		mId = id;
		mGivenNames 	= names;
		mPrefix 		= prefix;
		mPostfix		= postfix;
		
		mDisplayName	= this.getName();
	}
	
	public NameContainer(List<String> names, String prefix, String postfix) {
		this(AbstractModelClass.INVALID_ID, names, prefix, postfix);
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
	
	// SETTERS
	public void setFirstName(String firstName) {
		mGivenNames.set(0,	new Name(firstName));
	}

	public void setGivenName(int index, String name) {
		try {
			mGivenNames.set(index, new Name(name));
		} catch (Exception e) {
			System.err.println("It is likely that the index is 'Out of Bounds', meaning the user does not have that many names" + "\n");
			System.err.println("Remember that ArrayList in Java is Zero-Based!" + "\n");
			e.printStackTrace();
		}
	}
	
	public void setGivenNames(List<Name> givenNames) {
		mGivenNames = givenNames;
	}

	public void setLastName(String lastName) {
		mGivenNames.set(mGivenNames.size() - 1, new Name(lastName));
	}

	public void setPrefix(String prefix) {
		mPrefix = prefix;
	}
	
	public void setPostFix(String postfix) {
		mPostfix = postfix;
	}
	
	// GETTERS
	public String getFirstName() {
		return mGivenNames.get(0).getName();
	}

	public String getGivenName(int index) {
		// If the index is equal to or greater than the array size, we are out of bounds
		if (index >= mGivenNames.size()) return null;
		return mGivenNames.get(index).getName();
	}
	
	public List<Name> getGivenNames() {
		return mGivenNames;
	}
	
	public String getGivenNamesAsString() {
		StringBuilder output = new StringBuilder();
		
		Iterator<Name> i = mGivenNames.iterator();
		while (i.hasNext()) {
			output.append(i.next().toString());
			if (i.hasNext()) output.append(" ");
		}
		
		return output.toString();
	}
	
	public String getMiddleNamesAsString() {
		StringBuilder output = new StringBuilder();
		
		Iterator<Name> i = mGivenNames.iterator();
		Name currentName = null;
		
		// Throw Away the first name in the Data Structure
		i.next();
		
		// Loop through remaining names
		while (i.hasNext()) {
			// Get the next name
			currentName = i.next();
			
			// Only append to output if there still are names left
			// else the currentName is the last name and we can exit loop
			if (i.hasNext()) 	output.append(currentName.getName() + " ");
			else 				break;
		}
		
		// Cast to String an remove leading/trailing Whitespace
		return output.toString().trim();
	}

	public String getLastName() {
		return mGivenNames.get(mGivenNames.size() - 1).getName();
	}
	
	public String getName() {
		StringBuilder output = new StringBuilder();
		
		if (mPrefix != null || !mPrefix.equals("") ) output.append(mPrefix + " ");
		
		// Only Append First and Last Names
		output.append(mGivenNames.get(0).getName());
		output.append(" " + mGivenNames.get(mGivenNames.size() - 1).getName());
		
		if (mPostfix != null || !mPostfix.equals("")) output.append(" " + mPostfix);
		
		return output.toString();
	}
	
	public String getFullName() {
		StringBuilder output = new StringBuilder();
		
		if (mPrefix != null 	|| 	!mPrefix.equals("") 	) output.append(mPrefix + " ");
		if (mGivenNames != null || 	mGivenNames.size() > 0	) output.append(this.getGivenNamesAsString());
		if (mPostfix != null 	|| 	!mPostfix.equals("")	) output.append(" " + mPostfix);
		
		return output.toString();
	}
}

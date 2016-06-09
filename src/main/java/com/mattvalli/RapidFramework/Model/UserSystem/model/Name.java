package com.mattvalli.RapidFramework.Model.UserSystem.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.Model.UserSystem.dao.NameContainerDao;

@Entity
@Table(name = NameContainerDao.TABLE)
public class Name extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	// VALIDATION
		// Validate Field Size
		@Size(min=2, max = 4)
	// HIBERNATE
		// Define Table Column 
		@Column(name = NameContainerDao.COLUMN_PREFIX)
	private String 				prefix;
	
	
	// VALIDATION
		// Validate Field Size
		//@Size(min=2, max = 4)
	// HIBERNATE
		// Define Table Column
		@Column(name = NameContainerDao.COLUMN_POSTFIX)
	private String				postfix;
	
	// HIBERNATE
	@ElementCollection(	fetch 			= FetchType.EAGER															)
	@JoinTable(			name 			= NameContainerDao.JOIN_TABLE, 
						joinColumns 	= @JoinColumn(name = NameContainerDao.JOIN_CONTAINER_NAME) 					)
	@Column(			name			= "name"	)
	private List<String> 	names;
	
	
	// CONSTRUCTORS
	public Name() {
		this.mId = AbstractModelClass.INVALID_ID;
	}
	
	public Name(Integer id, List<String> names, String prefix, String postfix) {
		this.mId 			= id;
		this.names 			= names;
		this.prefix 		= prefix;
		this.postfix		= postfix;
		this.mDisplayName	= this.getFirstName() + " " + this.getLastName();
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
		
		output.append("Prefix: " + this.prefix	+ "\n");
		output.append("Names: ");
		for ( String name : this.names ) {
			output.append(name + " ");
		}
		output.append("\n");
		output.append("Postfix: " + this.postfix + "\n");
		
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
		this.names.set(0, firstName);
	}

	public void setName(int index, String name) {
		try {
			this.names.set(index, name);
		} catch (Exception e) {
			System.err.println("It is likely that the index is 'Out of Bounds', meaning the user does not have that many names" + "\n");
			System.err.println("Remember that ArrayList in Java is Zero-Based!" + "\n");
			e.printStackTrace();
		}
	}
	
	public void setNames(List<String> givenNames) {
		this.names = givenNames;
	}

	public void setLastName(String lastName) {
		this.names.set(this.names.size() - 1, lastName);
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setPostfix(String postfix) {
		this.postfix = postfix;
	}
	
	// GETTERS
	public String getPrefix() {
		return this.prefix;
	}
	
	public String getPostfix() {
		return this.postfix;
	}
	
	public String getFirstName() {
		return this.names.get(0);
	}

	public String getName(int index) {
		// If the index is equal to or greater than the array size, we are out of bounds
		if (index >= this.names.size()) return null;
		return this.names.get(index);
	}
	
	public List<String> getNames() {
		return this.names;
	}
	
	public String getNamesAsString() {
		StringBuilder output = new StringBuilder();
		
		Iterator<String> i = names.iterator();
		while (i.hasNext()) {
			output.append(i.next());
			if (i.hasNext()) output.append(" ");
		}
		
		return output.toString();
	}
	
	public String getMiddleNamesAsString() {
		StringBuilder output = new StringBuilder();
		
		Iterator<String> i = this.names.iterator();
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
		return this.names.get(names.size() - 1);
	}
	
	public String getName() {
		StringBuilder output = new StringBuilder();
		
		if (this.prefix != null && !this.prefix.equals("") ) output.append(this.prefix + " ");
		
		// Only Append First and Last Names
		if (this.names != null && this.names.size() > 0) {
			output.append(this.names.get(0));
			output.append(" " + this.names.get(this.names.size() - 1));
		}
		
		if (this.postfix != null && !this.postfix.equals("")) output.append(" " + this.postfix);
		
		return output.toString();
	}
	
	public String getFullName() {
		StringBuilder output = new StringBuilder();
		
		if (this.prefix 	!= null 	|| 	!this.prefix.equals("") 	) output.append(this.prefix + " ");
		if (this.names		!= null 	|| 	this.names.size() > 0		) output.append(this.getNamesAsString());
		if (this.postfix 	!= null 	|| 	!this.postfix.equals("")	) output.append(" " + this.postfix);
		
		return output.toString();
	}
}

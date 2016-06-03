package com.mattvalli.RapidFramework.Model.UserSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.dao.UserSystem.PersonDao;

@Entity
@Table(name = PersonDao.DATABASE + "." + PersonDao.TABLE)
public class Person extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name = PersonDao.COLUMN_NAME_FIRST)
	private String					mFirstName;
	
	@Column(name = PersonDao.COLUMN_NAME_LAST)
	private String					mLastName;
	
	@DateTimeFormat(pattern = PersonDao.DATE_FORMAT)
	@Column(name = PersonDao.COLUMN_DOB)
	private LocalDate				mDateOfBirth;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = PersonDao.JOIN_CONTAINER_NAME)
	private Name		 	mNames;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PersonDao.JOIN_GENDER)
	private Gender					mGender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PersonDao.JOIN_CONTACT)
	private Contact					mContact;

	
	// CONSTRUCTORS
	public Person() {
		// Empty
	}
	
	public Person(	String 				firstName,
					String				lastName,
					Name	 	givenNames,
					Gender				gender,
					LocalDate 			dateOfBirth	) {
		// Set Class Properties
		this.mNames 			= givenNames;
		this.mGender			= gender;
		this.mDateOfBirth	= dateOfBirth;
	}
	
	public Person(	String				firstName,
					String				lastName,
					Name	 	givenNames,
					LocalDate 			dateOfBirth	) {
		this(firstName, lastName, givenNames, null, dateOfBirth);
	}	
	
	public Person(	Name	 	givenNames,
					LocalDate 			dateOfBirth	) {
		this(givenNames.getFirstName(), givenNames.getLastName(), givenNames, null, dateOfBirth);
	}	
	
	public Person( 	String firstName,
					String lastName		) {
		this(firstName, lastName, null, null, null);
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("PERSON OBJECT" + "\n");
		
		// Loop through given names
		output.append("Full Name" + mNames.getFullName() + "\n");
		output.append("Date of Birth: " + mDateOfBirth.toString() + "\n");
		
		return output.toString();
	}
	
	public boolean equals(Object o) {
		if ( ! (o instanceof Person) ) return false;
		
		Person p = (Person) o;
		
		// Check Conditions
		if ( 		! this.mDateOfBirth.equals(	p.getDateOfBirth()	)		) return false;
		if (		! this.mNames.equals(	p.getNameContainer()	) 		) return false;
		
		return true;
	}
	
	// METHODS
	
	// SETTERS
	// Immediate
	public void setGender(Gender gender) {
		this.mGender = gender;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.mDateOfBirth = dateOfBirth;
	}
	
	public void setNameContainer(Name nameContainer) {
		this.mNames = nameContainer;
	}
	
	// Convenience
	public void setFirstName(String firstName) {
		//this.mNames.setFirstName(firstName);
		this.mFirstName = firstName;
	}

	public void setName(int index, String name) {
		this.mNames.setName(index, name);
	}
	
	public void setNames(ArrayList<String> names) {
		this.mNames.setNames(names);
	}

	public void setLastName(String lastName) {
		//this.mNames.setLastName(lastName);
		this.mLastName = lastName;
	}

	public void setPrefix(String prefix) {
		this.mNames.setPrefix(prefix);
	}
	
	public void setPostFix(String postfix) {
		this.mNames.setPostFix(postfix);
	}
	
	
	// GETTERS
	// Immediate
	public Gender getGender() {
		return this.mGender;
	}
	
	public LocalDate getDateOfBirth() {
		return this.mDateOfBirth;
	}
	
	public Name getNameContainer() {
		return this.mNames;
	}
	
	// Convenience
	public String getFirstName() {
		//return this.mNames.getFirstName();
		return this.mFirstName;
	}

	public String getName(int index) {
		return mNames.getName(index);
	}
	
	public List<String> getNames() {
		return mNames.getNames();
	}
	
	public String getGivenNamesAsString() {
		return mNames.getNamesAsString();
	}

	public String getLastName() {
		//return mNames.getLastName();
		return this.mLastName;
	}
	
	public String getName() {
		//return mNames.getName();
		return this.mFirstName + " " + this.mLastName;
	}
	
	public String getFullName() {
		//return mNames.getFullName();
		StringBuilder output = new StringBuilder(mFirstName);
		output.append(" " + mNames.getMiddleNamesAsString() + " ");
		output.append(mLastName);

		return output.toString();
	}

	
}

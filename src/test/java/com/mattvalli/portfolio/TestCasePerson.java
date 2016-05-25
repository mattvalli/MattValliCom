package com.mattvalli.portfolio;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

import com.mattvalli.RapidFramework.Model.UserSystem.NameContainer;
import com.mattvalli.RapidFramework.Model.UserSystem.Person;

import junit.framework.TestCase;

public class TestCasePerson extends TestCase {
	// PROPERTIES
	Person mTestPersonPrimary;
	Person mTestPersonCopy;
	Person mTestPersonDifferent;
	
	// TEST CASE PRECONDITIONS	
	protected void setUp() {
		// Matt's Names
		ArrayList<String> givenNamesMatt = new ArrayList<String>();
		givenNamesMatt.add("Matthew");
		givenNamesMatt.add("R.");
		givenNamesMatt.add("Valli");
		givenNamesMatt.trimToSize();
		
		// Alicia's Names
		ArrayList<String> givenNamesAlicia = new ArrayList<String>();
		givenNamesAlicia.add("Alicia");
		givenNamesAlicia.add("M.");
		givenNamesAlicia.add("Rabadon");
		givenNamesAlicia.trimToSize();
		
		
		mTestPersonPrimary 		= new Person(	new NameContainer(givenNamesMatt), 		LocalDate.of(1987, Month.MAY, 27)	);
		mTestPersonCopy			= new Person(	new NameContainer(givenNamesMatt), 		LocalDate.of(1987, Month.MAY, 27)	);
		mTestPersonDifferent	= new Person(	new NameContainer(givenNamesAlicia), 	LocalDate.of(1990, Month.MARCH, 11)	);
	}
	
	// TEST CASES
	@Test
	public void testPersonEqualityPositive() {
		assertTrue( 	mTestPersonPrimary.equals(mTestPersonCopy) 			);
	}
	
	@Test
	public void testPersonEqualityNegative() {
		assertFalse( 	mTestPersonPrimary.equals(mTestPersonDifferent) 	);
	}
}

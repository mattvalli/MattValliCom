package com.mattvalli.portfolio;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Test;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.Model.UserSystem.NameContainer;
import com.mattvalli.RapidFramework.Model.UserSystem.Person;
import com.mattvalli.portfolio.model.Author;
import com.mattvalli.portfolio.model.Book;
import com.mattvalli.portfolio.model.AssociateBookAuthor;

import junit.framework.TestCase;

public class TestCaseBook extends TestCase {
	
	// PROPERTIES
	protected Book mTestBookPrimary;
	protected Book mTestBookCopy;
	protected Book mTestBookDifferent;
	   
   // assigning the values
   protected void setUp(){
	   ArrayList<AssociateBookAuthor> authors = new ArrayList<AssociateBookAuthor>();
	   ArrayList<String> givenNames = new ArrayList<String>();
	   givenNames.add("Matthew");
	   givenNames.add("R.");
	   givenNames.add("Valli");
	   authors.add(new AssociateBookAuthor(AbstractModelClass.INVALID_ID,null, new Person(new NameContainer(givenNames), LocalDate.of(1987,Month.MAY, 27))));
	   
	   // Primary
      mTestBookPrimary 		= new Book(	1, 
	    		  						"Testing JUnit", 
	    		  						"How to Setup and Navigate JUnit", 
	    		  						authors,
	    		  						"ISBN:123456789ABCD", 
	    		  						"This book introduces Java Developers to Unit Testing using the JUnit Framework"	);
	      
      // Identical Copy with Different Reference (a new and separate instance)
	  mTestBookCopy 		= new Book(	1, 
										"Testing JUnit", 
										"How to Setup and Navigate JUnit", 
										authors,
										"ISBN:123456789ABCD", 
										"This book introduces Java Developers to Unit Testing using the JUnit Framework"	);
	      
      // Unique and Independent Book Instance
      mTestBookDifferent 	= new Book(	1, 
										"Introduction to Java", 
										"Learn the essential basics to developing software in the Java Language", 
										authors,
										"ISBN:123456789EFGHI", 
										"This book introduces Java Developers to Unit Testing using the JUnit Framework"	);
   }
   

   // TEST CASES
   @Test
   public void testObjectEqualityPositive() {	
      // Check if the equals method returns true for an equal object
      assertTrue(		mTestBookPrimary.equals(mTestBookCopy)			);     
   }
   
   @Test
   public void testObjectEqualityNegative() {
	   // Check if the equals method returns false for an in-equal object
	   assertFalse( 	mTestBookPrimary.equals(mTestBookDifferent)		);
   }
}

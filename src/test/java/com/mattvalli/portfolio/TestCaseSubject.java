package com.mattvalli.portfolio;

import java.util.HashMap;

import org.junit.Test;

import com.mattvalli.portfolio.model.Resource;
import com.mattvalli.portfolio.model.Subject;

import junit.framework.TestCase;

public class TestCaseSubject extends TestCase {
	// CONSTANTS
	
	// PROPERTIES
	private Subject mTestSubjectDefaultConstructor;
	private Subject mTestSubjectPrimary;
	private Subject mTestSubjectCopy;
	private Subject mTestSubjectDifferent;
	
	// METHODS
	public void setUp() {
		// Setup Testing Objects
			// Sub Objects for testing
			// Display Name
			String name_primary = "JUnit Test - Model Class - Subject";
			String name_diff	= "Different Instance of Subject";
			
			// Descriptions
			String desc_primary = "Testing the Subject Model Class";
			String desc_diff	= "This is a different Subject Instance";
			
			// Resources
				// Resource Samples
				Resource resource_1 	= new Resource(1,	"Website_informational");
				Resource resource_2		= new Resource(2,	"Website_professional");
				Resource resource_3 	= new Resource(3,	"Website_academic");
				Resource resource_4 	= new Resource(4,	"Website_tutorial");
				Resource resource_5 	= new Resource(5,	"Website_documentation");
				Resource resource_6 	= new Resource(6,	"Book_print");
				Resource resource_7 	= new Resource(7,	"Book_digital");
				Resource resource_8 	= new Resource(8,	"Book_audio");
				Resource resource_9		= new Resource(9,	"Image_print");
				Resource resource_10	= new Resource(10,	"Image_digital");
				Resource resource_11	= new Resource(11,	"Audio_clip");
				Resource resource_12	= new Resource(12,	"Audio_soundbite");
				Resource resource_13	= new Resource(13,	"Audio_music");
				Resource resource_14	= new Resource(14,	"API");
				Resource resource_15	= new Resource(15,	"SDK");
			
			HashMap<Integer,Resource> resources_primary = new HashMap<Integer,Resource>();
				resources_primary.put(resource_1.getId(), 	resource_1);
				resources_primary.put(resource_2.getId(), 	resource_2);
				resources_primary.put(resource_3.getId(), 	resource_3);
				resources_primary.put(resource_4.getId(), 	resource_4);
				resources_primary.put(resource_5.getId(), 	resource_5);
				
			HashMap<Integer,Resource> resources_copy	= new HashMap<Integer,Resource>();
				resources_primary.put(resource_1.getId(), 	resource_1);
				resources_primary.put(resource_2.getId(), 	resource_2);
				resources_primary.put(resource_3.getId(), 	resource_3);
				resources_primary.put(resource_4.getId(), 	resource_4);
				resources_primary.put(resource_5.getId(), 	resource_5);
			
			HashMap<Integer,Resource> resources_diff	= new HashMap<Integer,Resource>();
				resources_primary.put(resource_6.getId(), 	resource_6);
				resources_primary.put(resource_7.getId(), 	resource_7);
				resources_primary.put(resource_8.getId(), 	resource_8);
				resources_primary.put(resource_9.getId(), 	resource_9);
				resources_primary.put(resource_10.getId(),	resource_10);
				resources_primary.put(resource_11.getId(), 	resource_11);
				resources_primary.put(resource_12.getId(), 	resource_12);
				resources_primary.put(resource_13.getId(), 	resource_13);
				resources_primary.put(resource_14.getId(), 	resource_14);
				resources_primary.put(resource_15.getId(), 	resource_15);
			
			
		// Default Constructor
		mTestSubjectDefaultConstructor = new Subject();
		
		// TEST OBJECT - PRIMARY 
		mTestSubjectPrimary 	= new Subject();
		
		// TEST OBJECT - COPY
		mTestSubjectCopy		= new Subject();
		
		// TEST OBJECT - DIFFERENT
		mTestSubjectDifferent 	= new Subject();
		
	}
	
	// TEST CASES
	@Test
	public void testEqualityPositive() {
		assertTrue(		mTestSubjectPrimary.equals(mTestSubjectCopy) 		);
	}
	
	@Test
	public void testEqualityNegative() {
		assertFalse( 	mTestSubjectPrimary.equals(mTestSubjectDifferent) 	);
	}
}

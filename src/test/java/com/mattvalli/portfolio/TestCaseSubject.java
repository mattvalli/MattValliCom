package com.mattvalli.portfolio;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.junit.Test;

import com.mattvalli.portfolio.model.Resource;
import com.mattvalli.portfolio.model.ResourceType;
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
			Resource 	resource_1, 
						resource_2,
						resource_3,
						resource_4,
						resource_5,
						resource_6,
						resource_7,
						resource_8,
						resource_9,
						resource_10,
						resource_11,
						resource_12,
						resource_13,
						resource_14,
						resource_15;
				try {
					resource_1 	= new Resource("Website_informational", new URL(""), ResourceType.WEBSITE_INFORMATIONAL);
					resource_2	= new Resource("Website_professional", new URL(""), ResourceType.WEBSITE_PROFESSIONAL);
					resource_3 	= new Resource("Website_academic", new URL(""), ResourceType.WEBSITE_ACADEMIC);
					resource_4 	= new Resource("Website_tutorial", new URL(""), ResourceType.WEBSITE_TUTORIAL);
					resource_5 	= new Resource("Website_documentation", new URL(""), ResourceType.WEBSITE_DOCUMENTATION);
					resource_6 	= new Resource("Book_print", new URL(""), ResourceType.BOOK_PRINT);
					resource_7 	= new Resource("Book_digital", new URL(""), ResourceType.BOOK_DIGITAL);
					resource_8 	= new Resource("Book_audio", new URL(""), ResourceType.BOOK_AUDIO);
					resource_9		= new Resource("Image_print", new URL(""), ResourceType.IMAGE_PRINT);
					resource_10	= new Resource("Image_digital", new URL(""), ResourceType.IMAGE_DIGITAL);
					resource_11	= new Resource("Audio_clip", new URL(""), ResourceType.AUDIO_CLIP);
					resource_12	= new Resource(12,	"Audio_soundbite", new URL(""), ResourceType.AUDIO_SOUNDBITE);
					resource_13	= new Resource(13,	"Audio_music", new URL(""), ResourceType.AUDIO_SOUNDBITE);
					resource_14	= new Resource(14,	"API", new URL(""), ResourceType.API);
					resource_15	= new Resource(15,	"SDK", new URL(""), ResourceType.SDK);
					
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
				} catch (MalformedURLException e) {
					System.out.println("There is a Malformed URL String being supplied to a 'new URL()' constructor in TestCaseSubject.java");
					e.printStackTrace();
				}
			
			
			
			
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

package com.mattvalli.portfolio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mattvalli.RapidFramework.Model.UserSystem.Name;
import com.mattvalli.RapidFramework.dao.UserSystem.NameDao;

import junit.framework.TestCase;

public class TestCaseName extends TestCase {
	
	// PROPERTIES
	protected String 	name_sample_1 	= "Matthew";
	protected String 	name_sample_2	= "Matt";
	protected String 	name_sample_3	= "Matthew";
	protected String 	name_sample_4	= "Alicia";
	
	protected Name		mTestPrimary;
	protected Name		mTestSimilar;
	protected Name		mTestCopy;
	protected Name		mTestUnique;

	// DAO OBJECT
	@Autowired
	protected NameDao 	mNameDao;

	
	public void setUp() {
		mTestPrimary 	= new Name(name_sample_1);
		mTestSimilar	= new Name(name_sample_2);
		mTestCopy		= new Name(name_sample_3);
		mTestUnique		= new Name(name_sample_4);
	}
	
	@Test
	public void testQueryCreateTable() {
		System.out.println("QUERY STRING - query_create_table()");
		
		if (mNameDao == null) System.out.println("NameDao == null");
		
		System.out.println(this.mNameDao.query_create_table());
		
		assertTrue(true);
	}
	
}

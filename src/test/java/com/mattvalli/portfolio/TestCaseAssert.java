package com.mattvalli.portfolio;

import org.junit.Test;

import junit.framework.TestCase;

public class TestCaseAssert extends TestCase {
	
		// ASSER FALSE
		@Test
		public void testAssertFalsePositive() {
			assertFalse(true);
		}
	   
		@Test
		public void testAssertFalseNegative() {
			assertFalse(false);
		}
			   
		// ASSERT TRUE
		@Test
		public void testAssertTruePositive() {
			assertTrue(true);
		}
			   
		@Test
		public void testAssertTrueNegative() {
			assertTrue(false);
		}
	   
}

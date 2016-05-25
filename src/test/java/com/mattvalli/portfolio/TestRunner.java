package com.mattvalli.portfolio;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure; 

public class TestRunner implements Runnable {
	// CONSTANTS
	public static final boolean RUN_TEST_SUITE_JUNIT = false;
	public static final boolean RUN_TEST_SUITE_MODEL = true;
	
	// PROPERTIES
	//private Class<TestSuite>[] mTestSuites;
	
	// CONSTRUCTORS
	public TestRunner() {
		// EMPTY
	}
	
	// IMPLEMENTATION
	public void run() {
		Result result = JUnitCore.runClasses( 	TestSuiteModelClasses.class,
												TestSuiteJUnit.class 			);
		// Get the Failures
		
		if (result.getFailureCount() > 0) {
			System.out.println(	"FAILED TEST CASES "
								+ "(" + result.getFailureCount() + " of " + result.getRunCount() + "):");
		}
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.print("\n");
		System.out.println("All Test Cases Passed: " + result.wasSuccessful());
	}
	
	// LIFE-CYCLE
	public void setUp() {
		// Is it possible to create and populate a Data Structure for Managing Test Suites and the Classes they contain?
	}
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	
	// GETTERS
	
	// MAIN METHOD
	public static void main(String[] args) {
		// Construct a TestRunner
		TestRunner testRunnerManager = new TestRunner();
		
		// Run the TestRunner
		testRunnerManager.run();
		
		System.out.println("End Testing - Program Terminated");
	}
	
	
} 
package com.mattvalli.portfolio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TestCaseSubject.class,
	TestCaseBook.class,
	TestCasePerson.class
})
public class TestSuiteModelClasses {
}
package com.mattvalli.RapidFramework.HTML;

import java.util.HashMap;
import java.util.LinkedList;

public class HtmlBody extends HtmlElement {
	// CONSTANTS
	private static final String TAG_NAME = "body";
	
	// PROPERTIES
	private HtmlBodyHeader 					mBodyHeader;
	private HtmlNavigationElement 			mMainNavigation;
	private HtmlNavigationElement 			mSubNavigation;
	
	// Main Content
	private HashMap<Integer,HtmlSection> 	mSections;
	private LinkedList<Integer> 			mOrderSections;
	
	private HtmlBodyFooter 					mBodyFooter;
	
	// CONSTRUCTORS
	public HtmlBody() {
		super(TAG_NAME);
	}
	
	public HtmlBody(	HtmlBodyHeader 					header, 
						HtmlNavigationElement 			mainNavigation, 
						HtmlNavigationElement			subNavigation,
						HashMap<Integer,HtmlSection> 	sections,
						HtmlBodyFooter 					footer		) {
		super(TAG_NAME);
		
		// Set all Properties
		mBodyHeader 	= header;
		mMainNavigation = mainNavigation;
		mSubNavigation	= subNavigation;
		mSections		= sections;
		mBodyFooter		= footer;
	}
	
	// OVERRIDES
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// SETTERS
	
	// GETTERS
}

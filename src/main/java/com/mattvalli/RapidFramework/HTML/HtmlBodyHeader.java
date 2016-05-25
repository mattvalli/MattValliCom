package com.mattvalli.RapidFramework.HTML;

public class HtmlBodyHeader extends HtmlElement {
	// CONSTANTS
	private static final String TAG_NAME = "header";
	
	// PROPERTIES
	private String mContent;
	
	// CONSTRUCTORS
	public HtmlBodyHeader(String content) {
		super(TAG_NAME);
		mContent = content;
	}
	
	// OVERRIDES
	
	// POLYMORPHIC METHODS
	
	// METHODS
	
	// SETTERS
	public void setContent(String content) {
		mContent = content;
	}
	
	// GETTERS
	public String getContent() {
		return mContent;
	}
}

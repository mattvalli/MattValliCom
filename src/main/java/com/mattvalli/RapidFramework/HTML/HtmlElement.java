package com.mattvalli.RapidFramework.HTML;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class HtmlElement {
	// CONSTANTS
		// Single Tag Elements
		private static final String[] mSingleTagExceptions = {	"br",
																"img" 	};
	
	
	// PROPERTIES
	private String mTagName;
	private String mUsesClosingTag;
	private LinkedList<HtmlAttribute> mSupportedAttributes;
	
	
	private LinkedList<HtmlAttribute> mOrderHtmlAttributes;
	private HashMap<HtmlAttribute,Object> mHtmlAttributes;
	
	// CONSTRUCTOR
	public HtmlElement(String tagName) {
		mTagName = tagName;
	}
	
	// METHODS
	public String html() {
		StringBuilder output = new StringBuilder("<" + mTagName);
		
		// Fill in the tag properties
		for (HtmlAttribute attributeId : mOrderHtmlAttributes) {
			output.append(mHtmlAttributes.get(attributeId));
		}
		output.append(" ");
		
		return output.toString();
	}
	
	
	// SETTERS
	
	// GETTERS
	
}

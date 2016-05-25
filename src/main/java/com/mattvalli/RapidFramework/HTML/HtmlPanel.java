package com.mattvalli.RapidFramework.HTML;

import java.util.ArrayList;
import java.util.HashMap;

public class HtmlPanel<TKey,TValue> extends HtmlComponent {
	// CONSTANTS
	
	// PROPERTIES
	private ArrayList<TKey> mPresentationOrder;
	private HashMap<TKey,TValue> mObjectsByIdentifier;
	
	// CSS PROPERTIES
	
	
	// CONSTRUCTORS
	public HtmlPanel() {
		// Empty
	}
	
	public HtmlPanel(	HashMap<TKey,TValue> 	objectsByIdentifier,	
						ArrayList<TKey> 		presentationOrder		) {
		mPresentationOrder 		= presentationOrder;
		mObjectsByIdentifier 	= objectsByIdentifier;
	}
	
	// OVERRIDES
	
	// METHODS
	public String html() {
		StringBuilder output = new StringBuilder();
		
		// Create the Html for the Html Div Container
		output.append("<div id=\"" + "class=\"");
		
		// Loop through 
		
		// Loop through the ArrayList displaying the Objects in the HashMap
		
		// Close the Html Div Container
		
		return output.toString();
	}
	
	// SETTERS
	
	// GETTERS
}

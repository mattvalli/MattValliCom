package com.mattvalli.RapidFramework.HTML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.mattvalli.RapidFramework.ExternalFramework.ExternalFramework;
import com.mattvalli.RapidFramework.JS.JsComponent;

public class HtmlPage {
	// CONSTANTS
	
	// PROPERTIES
	private String mUrl;
	private String mUIDisplayName;
	private String mTitle;
	private HtmlDocumentType mDocumentType;
	
	private ArrayList<Integer> mHeadComponentOrder;
	private ArrayList<Integer> mBodyComponentOrder;
	
	private HashMap<Integer,HtmlComponent> mHeadComponents;
	private HashMap<Integer,HtmlComponent> mBodyComponents;
	
	private ArrayList<ExternalFramework> mFrameworks;
	
	String mPreScript;
	String mPostScript;
	
	// CONSTRUCTOR
	public HtmlPage() {
		// Empty
	}
	
	public HtmlPage(	String 							url, 
						String 							displayName, 
						HtmlDocumentType 				docType,
						String 							title, 
						HashMap<Integer,HtmlComponent> 	headComponents, 
						HashMap<Integer,HtmlComponent> 	bodyComponents,
						ArrayList<Integer>				headComponentOrder,
						ArrayList<Integer>				bodyComponentOrder,
						ArrayList<ExternalFramework>	frameworks,
						ArrayList<JsComponent>			jsComponents,
						String 							preScript,
						String							postScript			) {
		// Set the HtmlPage Object Properties
		mUrl 				= url;
		mUIDisplayName 		= displayName;
		mDocumentType		= docType;
		mHeadComponents		= headComponents;
		mBodyComponents		= bodyComponents;
		mHeadComponentOrder = headComponentOrder;
		mBodyComponentOrder = bodyComponentOrder;
		mPreScript			= preScript;
		mPostScript			= postScript;
	}
	
	// OVERRIDES
	
	// METHODS
	public String html() {
		StringBuilder output = new StringBuilder();
		
		// Combine the Components to construct a Web Page
		output.append(mPreScript + "\n");
		
		// Output the Document Type
		output.append(mDocumentType.html() + "\n");
		
		// Append the <head> tag
		output.append(this.head() + "\n");
		
		// Append the <body> tag
		output.append(this.body() + "\n");
		
		return output.toString();
	}
	
	public String head() {
		StringBuilder output = new StringBuilder();
		
		// Construct the <head> tag
		output.append("<head>" + "\n");
				
		// Loop through the BodyComponents
		Iterator<Integer> iterator = mHeadComponentOrder.iterator();
		
		while (iterator.hasNext()) {
			output.append(mHeadComponents.get(iterator.next()).html() + "\n");
		}
		
		// Close the <head>
		output.append("</head>" + "\n");
		
		return output.toString();
	}
	
	public String body() {
		StringBuilder output = new StringBuilder();
		
		// Construct the <body> tag
		output.append("<body>" + "\n");
		
		// Loop through the BodyComponents
		Iterator<Integer> iterator = mBodyComponentOrder.iterator();
		
		while (iterator.hasNext()) {
			output.append(mBodyComponents.get(iterator.next()).html() + "\n");
		}
		
		// Close the <body> tag
		output.append("</body>" + "\n");
		
		return output.toString();
	}
	
	// SETTERS
	
	// GETTERS
}

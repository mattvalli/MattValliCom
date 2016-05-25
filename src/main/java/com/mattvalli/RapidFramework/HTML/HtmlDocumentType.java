package com.mattvalli.RapidFramework.HTML;

public class HtmlDocumentType {
	// CONSTANTS
	
	// PROPERTIES
	private DocumentType mDocumentType;
	private HtmlLanguage mHtmlLanguage;
	
	// CONSTRUCTOR
	public HtmlDocumentType(DocumentType docType, HtmlLanguage lang) {
		// Set Class Properties
		mDocumentType 	= docType;
		mHtmlLanguage		= lang;
	}
	
	// OVERRIDE
	
	// METHODS
	public String html() {
		StringBuilder output = new StringBuilder();
		
		// Create the <!DOCTYPE ...
		output.append("<!DOCTYPE html PUBLIC ");
		output.append(mDocumentType.getDocumentTypeUrl());
		output.append(">" + "\n");
		
		// Construct HTML Tag
		output.append("<html");
		if (mHtmlLanguage != null) output.append("lang=\"" + mHtmlLanguage.getHtmlCode() + "\"");
		output.append(">");
		
		return output.toString();
	}
	
	// SETTERS
	
	// GETTERS
}

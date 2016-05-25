package com.mattvalli.RapidFramework.HTML;

public class HtmlLanguage {
	// CONSTANTS
	
	// PROPERTIES
	private LanguageType 	mLanguageType;
	private String			mDisplayName;
	private String			mHtmlCode;
	
	// CONSTRUCTORS
	public HtmlLanguage() {
		// EMPTY
	}
	
	public HtmlLanguage(	LanguageType language, 
							String displayName, 
							String htmlCode 		) {
		// Set Class Properties
		mLanguageType 	= language;
		mDisplayName 	= displayName;
		mHtmlCode		= htmlCode;
	}
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	public void setLanguageType(LanguageType languageType) {
		mLanguageType = languageType;
	}

	public void setDisplayName(String displayName) {
		mDisplayName = displayName;
	}

	public void setHtmlCode(String htmlCode) {
		mHtmlCode = htmlCode;
	}
	
	// GETTERS
	public LanguageType getLanguageType() {
		return mLanguageType;
	}

	public String getDisplayName() {
		return mDisplayName;
	}

	public String getHtmlCode() {
		return mHtmlCode;
	}
}

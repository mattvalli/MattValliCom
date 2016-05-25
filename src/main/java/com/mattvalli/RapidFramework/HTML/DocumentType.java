package com.mattvalli.RapidFramework.HTML;

public class DocumentType {
	
	// PROPERTIES
	private DocumentTypeIdentifier	mDocumentTypeId;
	private String mDocumentTypeUrl;
	private String mXmlnsUrl;
	
	// CONSTRUCTOR
	public DocumentType (	DocumentTypeIdentifier docTypeId, 
							String docTypeUrl,
							String xmlnsUrl		) {
		// Set Class Properties
		mDocumentTypeId			= docTypeId;
		mDocumentTypeUrl 	= docTypeUrl;
		mXmlnsUrl 			= xmlnsUrl;
	}
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	public void setDocumentTypeId(DocumentTypeIdentifier documentTypeId) {
		mDocumentTypeId = documentTypeId;
	}

	public void setDocumentTypeUrl(String documentTypeUrl) {
		mDocumentTypeUrl = documentTypeUrl;
	}

	public void setXmlnsUrl(String xmlnsUrl) {
		mXmlnsUrl = xmlnsUrl;
	}
	
	// GETTERS
	public DocumentTypeIdentifier getDocumentTypeId() {
		return mDocumentTypeId;
	}

	public String getDocumentTypeUrl() {
		return mDocumentTypeUrl;
	}

	public String getXmlnsUrl() {
		return mXmlnsUrl;
	}
}

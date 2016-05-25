package com.mattvalli.portfolio.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.TutorialDao;

@Entity
@Table(name = TutorialDao.DATABASE + "." + TutorialDao.TABLE)
public class Tutorial extends AbstractModelClass {
	// PROPERTIES
	@OneToMany(mappedBy = TutorialDao.TABLE, cascade = CascadeType.ALL, orphanRemoval = true)
	private Subject mSubject;
	
	@Column(name = TutorialDao.COLUMN_SUBTITLE)
	private String 	mSubtitle;
	
	@Column(name = TutorialDao.COLUMN_CONTENT)
	private String 	mContent;
	
	// CONSTRUCTORS
	public Tutorial() {
		// Empty
	}
	
	public Tutorial(	Integer id, 
						String 	displayName,
						String	subtitle,
						Subject subject,
						String 	content			) {
		mId 			= id;
		mDisplayName 	= displayName;
		mSubtitle		= subtitle;
		mSubject		= subject;
		mContent		= content;
	}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("TUTORIAL OBJECT" + "\n");
		
		output.append("ID: " + Integer.toString(mId) + "\n");
		output.append("Display Name: " + mDisplayName + "\n");
		output.append("Subtitle: " + mSubtitle + "\n");
		output.append("Subject:" + mSubject.getDisplayName() + "(ID: " + Integer.toString(mSubject.getId()) + ")" + "\n");
		output.append("Content: " + "\n");
		output.append(mContent + "\n");
		
		return output.toString();
	}
	
	// POLYMORPHIC METHODS
	public boolean equals(Object o) {
		if ( this == o) 					return true;
		if ( ! (o instanceof Tutorial) ) 	return false;
		
		// The object must be of type Tutorial
		Tutorial t = (Tutorial) o;
		
		// Equality Conditions
		if ( 	! this.mDisplayName.equals(t.getDisplayName()) 	) 	return false;
		if ( 	! this.mSubtitle.equals(t.getSubtitle()) 		)	return false;
		if ( 	! this.mSubject.equals(t.getSubject()) 			)	return false;
		if (	! this.mContent.equals(t.getContent()) 			)	return false;
		
		return true;
	}
	
	// METHODS
	
	// SETTERS
	public void setSubject(Subject subject) {
		this.mSubject = subject;
	}
	
	public void setSubtitle(String subtitle) {
		this.mSubtitle = subtitle;
	}

	public void setContent(String content) {
		this.mContent = content;
	}
	
	// GETTERS
	public Subject getSubject() {
		return this.mSubject;
	}
	
	public String getSubtitle() {
		return this.mSubtitle;
	}

	public String getContent() {
		return this.mContent;
	}
}

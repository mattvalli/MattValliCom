package com.mattvalli.portfolio.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.RapidFramework.Model.UserSystem.Person;

public class Portfolio extends AbstractModelClass {
	// CONSTANTS
	
	
	// PROPERTIES
	private Person								mPortfolioOwner;
	private Subject 							mSubject;
	private String								mTitle;
	private HashMap<Integer,Experience>			mExperience;
	private HashMap<Integer,Project>			mProjects;
	private HashMap<Integer,Skill>				mSkills;
	private HashMap<Integer,SocialMediaAccount>	mSocialMediaAccounts;
	private HashMap<Integer,Book>				mBooks;
	private HashMap<Integer,Resource>			mResources;
	private HashMap<Integer,Tutorial>			mTutorials;
	
	
	// Presentation Order
	private ArrayList<Integer> mPresentationOrderBooks;
	private ArrayList<Integer> mPresentationOrderExperience;
	private ArrayList<Integer> mPresentationOrderProjects;
	private ArrayList<Integer> mPresentationOrderResources;
	private ArrayList<Integer> mPresentationOrderSkills;
	private ArrayList<Integer> mPresentationOrderSocialMedia;
	private ArrayList<Integer> mPresentationOrderTutorials;
	
	// CONSTRUCTORS
	public Portfolio() {
		// Empty
	}
	
	public Portfolio(	Integer								id,
						Person								owner,
						Subject 							subject,
						String								title,
						HashMap<Integer,Book> 				books,
						HashMap<Integer,Experience> 		experience,
						HashMap<Integer,Project>			projects,
						HashMap<Integer,Skill>				skills,
						HashMap<Integer,SocialMediaAccount> socialMediaAccounts,
						HashMap<Integer,Tutorial>			tutorials,
						ArrayList<Integer> 					presentationOrderBooks,
						ArrayList<Integer> 					presentationOrderExperience,
						ArrayList<Integer> 					presentationOrderProjects,
						ArrayList<Integer> 					presentationOrderResources,
						ArrayList<Integer> 					presentationOrderSkills,
						ArrayList<Integer> 					presentationOrderSocialMedia,
						ArrayList<Integer> 					presentationOrderTutorials				) {
		// Set all properties
		mPortfolioOwner							= owner;
		mSubject 								= subject;
		mBooks									= books;
		mExperience								= experience;
		mProjects								= projects;
		mSkills 								= skills;
		mSocialMediaAccounts 					= socialMediaAccounts;
		mTutorials								= tutorials;
		
		// Order
		mPresentationOrderBooks 				= presentationOrderBooks;
		mPresentationOrderExperience		 	= presentationOrderExperience;
		mPresentationOrderProjects 				= presentationOrderProjects;
		mPresentationOrderResources				= presentationOrderResources;
		mPresentationOrderSkills				= presentationOrderSkills;
		mPresentationOrderSocialMedia			= presentationOrderSocialMedia;
		mPresentationOrderTutorials				= presentationOrderTutorials;
	}

	public Portfolio(	Integer								id,
						Person								owner,
						Subject 							subject,
						String								title,
						HashMap<Integer,Book> 				books,
						HashMap<Integer,Experience> 		experience,
						HashMap<Integer,Project>			projects,
						HashMap<Integer,Skill>				skills,
						HashMap<Integer,SocialMediaAccount> socialMediaAccounts,
						HashMap<Integer,Tutorial>			tutorials			) {
		// Set all properties
		this(	id,
				owner,
				subject, 
				title,
				books,
				experience,
				projects,
				skills,
				socialMediaAccounts,
				tutorials,
				null,
				null,
				null,
				null,
				null,
				null,
				null					);
}
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("PORTFOLIO OBJECT" + "\n");
		output.append( "\t" + mSubject.toString() 				);
		output.append( "\t" + mTitle							);
		output.append( "\t" + mBooks.toString() 				);
		output.append( "\t" + mExperience.toString() 			);
		output.append( "\t" + mProjects.toString()				);
		output.append( "\t" + mResources.toString()				);
		output.append( "\t" + mSkills.toString()				);
		output.append( "\t" + mSocialMediaAccounts.toString() 	);
		output.append( "\t" + mTutorials.toString() 			);
		
		return output.toString();
	}
	
	// METHODS
	
	// SETTERS
	public void setProfolioOwner(Person owner) {
		mPortfolioOwner = owner;
	}
	public void setSubject(Subject subject) {
		mSubject = subject;
	}
	public void setTitle(String title) {
		mTitle = title;
	}
	
	public void setExperience(HashMap<Integer, Experience> experience) {
		mExperience = experience;
	}
	
	public void setProjects(HashMap<Integer, Project> projects) {
		mProjects = projects;
	}
	
	public void setSkills(HashMap<Integer, Skill> skills) {
		mSkills = skills;
	}
	
	public void setSocialMediaAccounts(HashMap<Integer, SocialMediaAccount> socialMediaAccounts) {
		mSocialMediaAccounts = socialMediaAccounts;
	}
	
	public void setBooks(HashMap<Integer, Book> books) {
		mBooks = books;
	}
	
	public void setResources(HashMap<Integer, Resource> resources) {
		mResources = resources;
	}
	
	public void setTutorials(HashMap<Integer, Tutorial> tutorials) {
		mTutorials = tutorials;
	}
	
	public void setPresentationOrderBooks(ArrayList<Integer> presentationOrderBooks) {
		mPresentationOrderBooks = presentationOrderBooks;
	}
	
	public void setPresentationOrderExperience(ArrayList<Integer> presentationOrderExperience) {
		mPresentationOrderExperience = presentationOrderExperience;
	}
	
	public void setPresentationOrderProjects(ArrayList<Integer> presentationOrderProjects) {
		mPresentationOrderProjects = presentationOrderProjects;
	}
	
	public void setPresentationOrderResources(ArrayList<Integer> presentationOrderResources) {
		mPresentationOrderResources = presentationOrderResources;
	}
	
	public void setPresentationOrderSkills(ArrayList<Integer> presentationOrderSkills) {
		mPresentationOrderSkills = presentationOrderSkills;
	}
	
	public void setPresentationOrderSocialMedia(ArrayList<Integer> presentationOrderSocialMedia) {
		mPresentationOrderSocialMedia = presentationOrderSocialMedia;
	}
	
	public void setPresentationOrderTutorials(ArrayList<Integer> presentationOrderTutorials) {
		mPresentationOrderTutorials = presentationOrderTutorials;
	}
	
	// GETTERS
	public Person getPortfolioOwner() {
		return mPortfolioOwner;
	}
	public Subject getSubject() {
		return mSubject;
	}
	public String getTitle() {
		return mTitle;
	}

	public HashMap<Integer, Experience> getExperience() {
		return mExperience;
	}
	
	public HashMap<Integer, Project> getProjects() {
		return mProjects;
	}

	public HashMap<Integer, Skill> getSkills() {
		return mSkills;
	}

	public HashMap<Integer, SocialMediaAccount> getSocialMediaAccounts() {
		return mSocialMediaAccounts;
	}

	public HashMap<Integer, Book> getBooks() {
		return mBooks;
	}

	public HashMap<Integer, Resource> getResources() {
		return mResources;
	}

	public HashMap<Integer, Tutorial> getTutorials() {
		return mTutorials;
	}

	public ArrayList<Integer> getPresentationOrderBooks() {
		return mPresentationOrderBooks;
	}

	public ArrayList<Integer> getPresentationOrderExperience() {
		return mPresentationOrderExperience;
	}

	public ArrayList<Integer> getPresentationOrderProjects() {
		return mPresentationOrderProjects;
	}

	public ArrayList<Integer> getPresentationOrderResources() {
		return mPresentationOrderResources;
	}

	public ArrayList<Integer> getPresentationOrderSkills() {
		return mPresentationOrderSkills;
	}

	public ArrayList<Integer> getPresentationOrderSocialMedia() {
		return mPresentationOrderSocialMedia;
	}

	public ArrayList<Integer> getPresentationOrderTutorials() {
		return mPresentationOrderTutorials;
	}
	
}

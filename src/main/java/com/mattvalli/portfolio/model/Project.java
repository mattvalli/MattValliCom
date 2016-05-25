package com.mattvalli.portfolio.model;

import java.net.URL;
import java.util.List;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;

public class Project extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	private String			mName;
	private String			mDescription;
	private URL				mGithubRepository;
	private URL				mLiveProjectUrl;
	
	private List<Skill>		mSkills;
	private	List<Subject> 	mSubjects;
	
	// CONSTRUCTORS
	public Project() {
		// Empty
	}
	
	public Project(	Integer 		id,
					String			displayName,
					String			name,
					String			description,
					URL				githubRepository,
					URL				liveProjectUrl,
					List<Skill> 	skillsUsed,
					List<Subject>	subjectsCovered		) {
		// Set Properties
		this.mId 				= id;
		this.mDisplayName 		= displayName;
		this.mName				= name;
		this.mDescription		= description;
		this.mGithubRepository	= githubRepository;
		this.mLiveProjectUrl	= liveProjectUrl;
		this.mSkills			= skillsUsed;
		this.mSubjects			= subjectsCovered;
	}
	
	public Project(String			name,
			String			description,
			URL				githubRepository,
			URL				liveProjectUrl,
			List<Skill> 	skillsUsed,
			List<Subject>	subjectsCovered		) {
		// Set Properties
		this(AbstractModelClass.INVALID_ID, name, name, description, githubRepository, liveProjectUrl, skillsUsed, subjectsCovered);	
	}
	
	// OVERRIDES
	
	// METHODS
	
	// SETTERS
	
	// GETTERS
}

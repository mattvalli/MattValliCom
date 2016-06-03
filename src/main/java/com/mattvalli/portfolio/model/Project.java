package com.mattvalli.portfolio.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.ProjectDao;

@Entity
@Table(name = ProjectDao.DATABASE + "." + ProjectDao.TABLE)
public class Project extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Column(name = ProjectDao.COLUMN_NAME)
	private String			mName;
	
	@Column(name = ProjectDao.COLUMN_DESCRIPTION)
	private String			mDescription;
	
	private URL				mGithubRepository;
	private URL				mLiveProjectUrl;
	
	@OneToMany
	private List<Skill>		mSkills;
	
	@OneToMany
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
	public void setName(String name) {
		this.mName = name;
	}

	public void setDescription(String description) {
		this.mDescription = description;
	}

	public void setGithubRepository(URL githubRepository) {
		this.mGithubRepository = githubRepository;
	}
	
	@Column(name = ProjectDao.COLUMN_GITHUB_REPOSITORY)
	public void setGithubRepository(String githubRepository) throws MalformedURLException {
			this.mGithubRepository = new URL(githubRepository);	
	}

	public void setLiveProjectUrl(URL liveProjectUrl) {
		this.mLiveProjectUrl = liveProjectUrl;
	}
	
	@Column(name = ProjectDao.COLUMN_LIVE_PROJECT)
	public void setLivProjectUrl(String liveProjectUrl) throws MalformedURLException {
		this.mLiveProjectUrl = new URL(liveProjectUrl);
	}

	public void setSkills(List<Skill> skills) {
		this.mSkills = skills;
	}

	public void setSubjects(List<Subject> subjects) {
		this.mSubjects = subjects;
	}
	
	// GETTERS
	public String getName() {
		return this.mName;
	}

	public String getDescription() {
		return this.mDescription;
	}

	public URL getGithubRepository() {
		return this.mGithubRepository;
	}
	
	@Column(name = ProjectDao.COLUMN_GITHUB_REPOSITORY)
	public String getGithupRepositoryAsString() {
		return this.mGithubRepository.toString();
	}

	public URL getLiveProjectUrl() {
		return this.mLiveProjectUrl;
	}
	
	@Column(name = ProjectDao.COLUMN_LIVE_PROJECT)
	public String getLiveProjectAsString() {
		return this.mLiveProjectUrl.toString();
	}

	public List<Skill> getSkills() {
		return this.mSkills;
	}

	public List<Subject> getSubjects() {
		return this.mSubjects;
	}
}

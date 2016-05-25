package com.mattvalli.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import com.mattvalli.RapidFramework.Model.AbstractModelClass;
import com.mattvalli.portfolio.dao.ExperienceDao;

@Entity
@Table(name = ExperienceDao.DATABASE + "." + ExperienceDao.TABLE)
public class Experience extends AbstractModelClass {
	// CONSTANTS
	
	// PROPERTIES
	@Enumerated(EnumType.ORDINAL)
	@Column(name = ExperienceDao.JOIN_TYPE_EXPERIENCE,  nullable = false)
	private ExperienceType mType;
	
	@Column(name = ExperienceDao.COLUMN_JOB_TITLE)
	private String mJobTitle;
	
	@Column(name = ExperienceDao.COLUMN_DESC, nullable = true)
	private String 	mDescription;
	
	@OneToMany
	@JoinColumn(name = ExperienceDao.JOIN_BUSINESS)
	private Business mBusiness;
	
	@DateTimeFormat(pattern = ExperienceDao.DATE_FORMAT)
	@Column(name = ExperienceDao.COLUMN_DATE_START, nullable = false)
	private LocalDate		mStartDate;
	
	@DateTimeFormat(pattern = ExperienceDao.DATE_FORMAT)
	@Column(name = ExperienceDao.COLUMN_DATE_END)
	private LocalDate		mEndDate;
	
	// CONSTRUCTORS
	public Experience() {
		// Empty
	}
	
	public Experience(	Integer id, 
						String displayName, 
						ExperienceType type,
						String jobTitle, 
						String description, 
						Business business, 
						LocalDate startDate, 
						LocalDate endDate		) {
		// Set Properties
		mId 			= id;
		mDisplayName 	= displayName;
		mType			= type;
		mJobTitle		= jobTitle;
		mDescription	= description;
		mBusiness		= business;
		mStartDate		= startDate;
		mEndDate		= endDate;
	}
	
	
	// OVERRIDES
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("ExperiencAbstract OBJECT");
		
		output.append("Description: " 										+ "\n");
		output.append(mDescription 											+ "\n");
		
		output.append("Start Date: " 	+ mStartDate.toString(ExperienceDao.DATE_FORMAT) 	+ "\n");
		output.append("End Date: " 		+ mEndDate.toString(ExperienceDao.DATE_FORMAT) 	+ "\n");
		
		return output.toString();
	}
	
	// METHODS
	
	// SETTERS
	public void setType(ExperienceType type) {
		this.mType = type;
	}
	
	public void setDescription(String description) {
		this.mDescription = description;
	}
	public void setStartDate(LocalDate startDate) {
		this.mStartDate = startDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.mEndDate = endDate;
	}
	
	// GETTERS
	public ExperienceType getType() {
		return this.mType;
	}
	
	public String getDescription() {
		return this.mDescription;
	}
	public LocalDate getStartDate() {
		return this.mStartDate;
	}
	public LocalDate getEndDate() {
		return this.mEndDate;
	}
}

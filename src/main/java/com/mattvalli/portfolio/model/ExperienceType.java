package com.mattvalli.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_EXPERIENCE")
public enum ExperienceType {
	ACADEMIC,
	WORK,
	LIFE
}

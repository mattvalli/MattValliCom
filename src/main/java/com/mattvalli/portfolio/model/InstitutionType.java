package com.mattvalli.portfolio.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TYPE_INSTITUTION")
public enum InstitutionType {
	// American Format
	PRESCHOOL,
	ELEMENTARY_SCHOOL,
	JUNIOR_HIGH_SCHOOL,
	MIDDLE_SCHOOL,
	HIGH_SCHOOL,
	PREP_SCHOOL,
	JUNIOR_COLLEGE,
	UNIVERSITY,
	TRADE_SCHOOL
}

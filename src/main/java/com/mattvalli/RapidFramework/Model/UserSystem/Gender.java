package com.mattvalli.RapidFramework.Model.UserSystem;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "GENDER")
public enum Gender {
	FEMALE,
	MALE,
	UNSPECIFIED
}

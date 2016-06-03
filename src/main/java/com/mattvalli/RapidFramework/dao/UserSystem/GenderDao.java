package com.mattvalli.RapidFramework.dao.UserSystem;

import com.mattvalli.RapidFramework.dao.AbstractInterfaceDao;

public interface GenderDao extends AbstractInterfaceDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL = "Gender";
		// Database
		public static final String DATABASE		= "USER_SYSTEM";
		public static final String TABLE		= "Gender";
		// Columns
		public static final String COLUMN_ENUM_VALUE	= "enum_value";
		public static final String COLUMN_ENUM_LABEL	= "enum_label";
}

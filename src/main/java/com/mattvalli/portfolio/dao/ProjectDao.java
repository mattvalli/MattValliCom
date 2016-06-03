package com.mattvalli.portfolio.dao;

import com.mattvalli.RapidFramework.dao.AbstractInterfaceDao;

public interface ProjectDao extends AbstractInterfaceDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL = "Project";
		// Database
		public static final String DATABASE				= "PORTFOLIO";
		public static final String TABLE				= "PROJECT";
		// Columns
		public static final String COLUMN_NAME			= "name";
		public static final String COLUMN_DESCRIPTION	= "description";
		public static final String COLUMN_GITHUB_REPOSITORY	= "url_github_repository";
		public static final String COLUMN_LIVE_PROJECT		= "url_live_project";
}

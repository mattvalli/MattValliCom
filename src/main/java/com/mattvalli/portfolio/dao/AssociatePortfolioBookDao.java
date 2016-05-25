package com.mattvalli.portfolio.dao;

public interface AssociatePortfolioBookDao {
	// CONSTANTS
	public static final String CLASSNAME_MODEL	= "AssociatePortfolioBook";
		// Database
		public static final String DATABASE		= "PORTFOLIO";
		public static final String TABLE		= "ASSOCIATE_PORTFOLIO_BOOK";
		// Column
		public static final String JOIN_PORTFOLIO	= "fk_portfolio";
		public static final String JOIN_BOOK		= "fk_book";
}

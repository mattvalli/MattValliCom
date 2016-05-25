package com.mattvalli.RapidFramework.dao.UserSystem;

import java.util.List;

import com.mattvalli.RapidFramework.Model.UserSystem.Name;

public interface NameDao {
	// CONSTANTS
	public static final String ENTITY 			= "Name";
	public static final String TABLE			= "NAME";
	public static final String COLUMN_NAME		= "name";
	public static final String COLUMN_ID		= "id";
	
	// TYPES
	public static final String TYPE_ID 			= "INTEGER";
	public static final String TYPE_NAME		= "VARCHAR";
	
	// TYPE SIZE
	public static final Integer TYPE_SIZE_ID	= 11;
	public static final Integer TYPE_SIZE_NAME	= 60;
	
	// QUERIES
	public static final String QUERY_CREATE_TABLE		= 	"CREATE TABLE " + NameDao.TABLE + "("
														+	NameDao.COLUMN_ID 	+ " " 	+ TYPE_ID 		+ "(" 	+ Integer.toString(NameDao.TYPE_SIZE_ID) 	+ ")" 
																						+ "NOT_NULL" 	+ " " 	+ "AUTO_INCREMENT" 							+ ","
														+	NameDao.COLUMN_NAME	+ " "	+ TYPE_NAME 	+ "(" 	+ Integer.toString(NameDao.TYPE_SIZE_NAME) 	+ ")"
														+	")";
	
	public static final String QUERY_DELETE_BY_ID 		= "DELETE FROM " + NameDao.TABLE + " WHERE id = :id";  
	public static final String QUERY_DELETE_BY_NAME 	= "DELETE FROM " + NameDao.TABLE + " WHERE name = :name"; 

	// CREATE
	String query_create_table();
	void saveName(Name name);
	
	// READ
	Name findById(int id);
	Name		findNameByName(String name);
	List<Name> 	findAllNames();
	
	// DELETE
	void deleteNameById(int id);
	void deleteNameByName(String name);
	
}

package com.mattvalli.RapidFramework.Model.UserSystem.service;

import java.util.List;

import com.mattvalli.RapidFramework.Model.UserSystem.model.Name;


public interface NameService {
	// CREATE
	String queryCreateTable();
	
	// READ
	void save(Name name);
	
	Name findById(int id);
	Name findNameById(Integer id);
    Name findName(String name);
    
    List<Name> findAllNames(); 
    
     
    // UPDATE
    void update(Name name);
     
    // DELETE
    void deleteNameById(Integer id);
 
    
 
    boolean isNameUnique(Integer id, String name);
}

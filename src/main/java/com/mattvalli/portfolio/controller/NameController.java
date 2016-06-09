package com.mattvalli.portfolio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mattvalli.RapidFramework.Model.UserSystem.model.Name;
import com.mattvalli.RapidFramework.Model.UserSystem.service.NameService;
import com.mattvalli.portfolio.model.Employee;

@Controller
@RequestMapping(value = { "/name", "/names" } )
public class NameController {
	// CONSTANTS
	private static final Boolean DEBUG_HIBERNATE_COLLECTIONS 	= false;
	private static final Boolean DEBUG_REQUEST_MAPPING			= true;
	
	// PROPERTIES
	@Autowired
	private NameService nameService;
	
	// CONSTRUCTOR
	public NameController() {}
	
	@RequestMapping(method = RequestMethod.GET)
	public String searchNames(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listNames(ModelMap model) {
    	// Use the Name employeeService to retrieve all the 'Names' from the DataSource/Database
    	List<Name> names = nameService.findAllNames();
    	
    	// Add the 'List<Name> names' to the ModelMap for access by the View Implementation (.jsp)
    	model.addAttribute("names", names);
    	
    	if (DEBUG_HIBERNATE_COLLECTIONS == true ) System.out.println("NAMES:\n" + names.toString());
    	
    	return "list-names";
    }
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newName(ModelMap model) {
		// Create a Name Instance to hand to the model
		Name name = new Name();
		// Because we are using Dependency Injection
		// we must create an ArrayList of Strings to inject into the Default Object Instance
		name.setNames(new ArrayList<String>());
		model.addAttribute("name", name);
		
		// Inform the form that this is a not a record found in the database
		model.addAttribute("edit", false);
		
		return "form_name";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editName(ModelMap model, @PathVariable Integer id) {
		if (DEBUG_REQUEST_MAPPING == true) { 
			System.out.println("ENTER");
			System.out.println("CLASS: NameController.editName(ModelMap, @PathVariable Integer)");
			System.out.println("PATH: /name*/edit/{id}");
			System.out.println("METHOD: GET");
		}
		// Use the NameService to locate the name in the database and add it to the Model Map
		Name name  = nameService.findById(id);
		model.addAttribute("name", name);
		
		// Inform the form that this is a record from the database
		model.addAttribute("edit", true);
		
		return "form_name";
	}
	
	/*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String saveName(		@Valid 
    							Name 			name, 
    							BindingResult 	result,
    							ModelMap 		model	) {
    	if (DEBUG_REQUEST_MAPPING == true) { 
			System.out.println("ENTER");
			System.out.println("CLASS: NameController.saveName(ModelMap, @PathVariable Integer)");
			System.out.println("PATH: /name*/new");
			System.out.println("METHOD: POST");
		}
    	
    	System.out.println("************************************************************");
    	System.out.print(name.toString());
    	System.out.println("************************************************************");
    	
    	/*
    	// IF the previous result has errors, return back the form_name.jsp to display errors
        if (result.hasErrors()) {
            return "form_name";
        }
		*/
	
        System.out.print("Saving Name...");
        // Save the Name to the Database
        nameService.save(name);
        System.out.println("..................SAVED!");
        
        // Update the ModelMap with a success message
        model.addAttribute("success", "Name " + name.getName() + " registered successfully");
        return "form_name";
    }
	
	/*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateName(	@Valid
    							Name 			name, 
    							BindingResult 	result,
    							@PathVariable
    							Integer			id,
    							ModelMap 		model) {
 
    	if (result.hasErrors() 	) {	return "form_name";	}
    	if ( name == null		) {
    		model.addAttribute("failure", "Name is null");
    		return "form_name";
    	}
    	
    	System.out.println("************************************************************");
    	System.out.println(name.toString());
    	System.out.println("************************************************************");
    	// Persist the Changes to the Database through the NameService
    	nameService.save(name);
    	model.addAttribute("success", "Name " + name.getName()  + " updated successfully");
    	
    	return "form_name";
    }
	
	// Set Service Object
	public void setNameService(NameService object) {
		this.nameService = object;
	}
}

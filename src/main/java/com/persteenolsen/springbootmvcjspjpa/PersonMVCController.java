package com.persteenolsen.springbootmvcjspjpa;
 
import java.util.List;
 

import javax.validation.Valid;
import org.springframework.validation.BindingResult;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.persteenolsen.springbootmvcjspjpa.PersonEntity;
import com.persteenolsen.springbootmvcjspjpa.PersonService;

// Used by mothod mvcaddPerson for TESTING!!
//import org.springframework.web.bind.annotation.RequestParam;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class PersonMVCController {
	
	// Used by mothod mvcaddPerson for TESTING!!
	//@Autowired 
	//private PersonRepository personrepository;

	@Autowired
    private PersonService personService;
	
	//--------------------------------Use by MVC / JSP --------------------------------------------------
	// GET Persons (JSP) - Can be called by the URL
	@RequestMapping(value="/mvclistpersons", method=RequestMethod.GET)
	public ModelAndView mvclistpersons() {

	 ModelAndView model = new ModelAndView("person_list");
	 List<PersonEntity> personList = personService.getAll();
	 model.addObject("personList", personList);
	 
	 return model;
	}

	@RequestMapping(value="/mvcdeleteperson/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") long id) {
	 personService.deletePerson(id);
	 
	 return new ModelAndView("redirect:/demo/mvclistpersons");
	}

	
	@RequestMapping(value="/mvccreateperson/", method=RequestMethod.GET)
	public ModelAndView createPerson() {
	 ModelAndView model = new ModelAndView();
	 
	 PersonEntity person = new PersonEntity();
	 model.addObject("personForm", person);
	 model.setViewName("person_form");
	 
	 return model;
	}
	
	@RequestMapping(value="/mvcupdateperson/{id}", method=RequestMethod.GET)
	public ModelAndView editPerson(@PathVariable long id) {
	 ModelAndView model = new ModelAndView();
	 
	 PersonEntity person = personService.getPersonById(id);
	 model.addObject("personForm", person);
	 model.setViewName("person_form");
	 
	 return model;
	}

	
	@RequestMapping(value="/mvcsaveperson", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("personForm") PersonEntity person, BindingResult bindingResult) {
	
		if (bindingResult.hasErrors()) {
			
	       return "person_form";
		}
		
		//System.out.println(person.toString());

	    personService.saveOrUpdate(person);
	    return "redirect:/demo/mvclistpersons";
	   
	}
	

	//------------------------------- TEST - Use by URL -------------------------------------------------
	//  Add a Persons - Can be used by the URL for TEST
	/*@GetMapping(path="/mvcaddperson") 
	public @ResponseBody String mvcaddPerson (@RequestParam String name, @RequestParam String age) {
                        
        int t = new Integer(age);
        PersonEntity s = new PersonEntity();
        s.setName(name);
		s.setAge(t);
		personrepository.save(s);

		return "Saved";
	}*/

	//-------------------------------------- TEST - For a REST API - URL --------------------------------------
    // GET Persons (JSON) - Can be called by the URL for testing
    @GetMapping(path = "/mvcgetpersons")
    public @ResponseBody List<PersonEntity> mvcgetPersons() {
		return personService.getAll();
		
	}
	

}
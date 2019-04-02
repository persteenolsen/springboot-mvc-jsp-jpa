

package com.persteenolsen.springbootmvcjspjpa;

import java.util.Map;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// This Controller is saving a welcome message in the model to be used in the JSP View
// It is using GetMapping to get url request at top level -> Entry page / Home / Welcome :-)
@Controller
public class WelcomeController {
	
	private String helloworld = "";
	
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {

		helloworld = "Welcome to a Java Spring Boot MVC JSP JPA Web application!";

		model.put("welcomemessage", helloworld);
				
		return "welcome";
	}
}
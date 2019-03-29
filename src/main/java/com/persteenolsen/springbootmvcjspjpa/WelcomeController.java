

package com.persteenolsen.springbootmvcjspjpa;

import java.util.Map;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	private String helloworld = "";
	
	@GetMapping("/")
	//@GetMapping("/welcome")
	public String welcome(Map<String, Object> model) {

		helloworld = "Welcome to a Java Spring Boot MVC JSP JPA Web application!";

		model.put("welcomemessage", helloworld);
				
		return "welcome";
	}
}
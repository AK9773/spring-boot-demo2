package test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {
	
	@GetMapping("/home")
	public String home() {
		return "This is Home page";
	}
	
	@GetMapping("/login")
	public String login() {
		return "This is Login page";
	}
	
	@GetMapping("/register")
	public String register() {
		return "This is Registration page";
	}
	
	@GetMapping("/registeration")
	public String registeration() {
		return "This is Registration page, register here";
	}

}

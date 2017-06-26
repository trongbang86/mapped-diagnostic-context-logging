package sample.logback;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public @ResponseBody User login() {
		User user = new User();
		user.setId(-1l);
		return user;
	}
}

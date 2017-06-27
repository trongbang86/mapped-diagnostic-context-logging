package sample.logback;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {
	
	private static Logger log = LoggerFactory.getLogger(SessionController.class);

	@Autowired
	private User user;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String index() {
		if (user.getId() < 0) {
			log.debug("User has to log in");
			return "login";
		} else {
			log.debug("User has logged in already");
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public String login(
			@RequestParam(value="email", required=true) String email,
			@RequestParam(value="password", required=true) String password) {
		log.debug("Email: {}", email);
		if (user.getId() < 0) {
			log.debug("Looking for user with email: {}", email);
			User u = userService.getUser(email, password);
			log.debug("Found user: {}", u);
			user.setId(u.getId());
			user.setName(u.getName());
			return "redirect:/dashboard";
		}
		throw new RuntimeException("User has already logged in");
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		log.debug("User id={} has logged out", user.getId());
		session.invalidate();
		return "redirect:/";
	}
}

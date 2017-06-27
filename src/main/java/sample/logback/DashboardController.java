package sample.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
	
	private static Logger log = LoggerFactory
			.getLogger(DashboardController.class);
	
	@Autowired
	private User user;
	
	@RequestMapping("/dashboard")
	public String main() {
		if (user.getId() < 0) {
			log.debug("User has not logged in");
			return "redirect:/";
		} else {
			log.debug("User has logged in: {}", user.getName());
			return "dashboard";
		}
	}
}

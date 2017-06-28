package sample.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	private Logger log = LoggerFactory.getLogger(UserService.class);
	
	public User getUser(String email, String password) {
		User res = new User();
		if (email.equalsIgnoreCase("1@gmail.com")) {
			res.setId(1l);
			res.setName("One");
		} else if (email.equalsIgnoreCase("2@gmail.com")) {
			res.setId(2l);
			res.setName("TWO");
		} else if (email.equalsIgnoreCase("3@gmail.com")) {
			res.setId(3l);
			res.setName("THREE");
		} else {
			log.debug("Couldn't find any user. The email address was {}", email);
			throw new RuntimeException("User not exist");
		}
		return res;
	}
}

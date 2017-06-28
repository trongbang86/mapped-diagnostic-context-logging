package sample.logback;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

@Component
public class UserFilter extends AbstractRequestLoggingFilter {

	public static final String USER = "user";
	
	@Autowired
	private User user;
	
	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
		if (user.getId() < 0) {
			MDC.put(USER, "[Anonymous]");
		} else {
			MDC.put(USER, user.toString());
		}

	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		//do nothing
	}

}

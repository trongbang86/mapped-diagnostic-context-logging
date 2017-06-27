package sample.logback;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="session", 
	proxyMode= ScopedProxyMode.TARGET_CLASS)
public class User {
	private Long id = -1l; //negative numbers mean "not exist"
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "[User:" + getName() + "]"; 
	}
	
}

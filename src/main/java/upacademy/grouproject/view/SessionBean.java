package upacademy.grouproject.view;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.apache.shiro.SecurityUtils;

@Named("SessionBean")
@SessionScoped
public class SessionBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username = (String) SecurityUtils.getSubject().getPrincipal();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
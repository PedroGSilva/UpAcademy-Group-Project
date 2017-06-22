package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Questions extends EntityModel implements Serializable{
	private static final long serialVersionUID = 1L;

	private String question;
	private String type;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}

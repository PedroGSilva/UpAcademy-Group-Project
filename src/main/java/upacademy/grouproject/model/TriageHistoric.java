package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class TriageHistoric extends EntityModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nameP;
	private char priorityL;

	// Getters & Setters
	public String getNameP() {
		return nameP;
	}

	public void setNameP(String nameP) {
		this.nameP = nameP;
	}

	public char getPriorityL() {
		return priorityL;
	}

	public void setPriorityL(char priorityL) {
		this.priorityL = priorityL;
	}

}

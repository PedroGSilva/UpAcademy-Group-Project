package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import upacademy.grouproject.model.Patient;

@Entity
public class Triage extends EntityModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// Patient nHS
	@Size(min = 1, message = "Please insert a NHS card number")
	private String nHS;

	// Priority level
	private char priorityLevel;

	
	// Getters & Setters
	public char getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(char priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public String getnHS() {
		return nHS;
	}

	public void setnHS(String nHS) {
		this.nHS = nHS;
	}

	
}

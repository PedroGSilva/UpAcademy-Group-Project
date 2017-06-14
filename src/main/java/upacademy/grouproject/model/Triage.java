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
	private Patient nHS;
	
	// Priority level
	private char priorityLevel;

	// Getters & Setters
	public char getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(char priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

	public Patient getnHS() {
		return nHS;
	}

	public void setnHS(Patient nHS) {
		this.nHS = nHS;
	}
}

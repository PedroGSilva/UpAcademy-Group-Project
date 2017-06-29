package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TriageHistoric extends EntityModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "PATIENT_ID")
	private Patient patient;

	private char priorityL;

	// Getters & Setters
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public char getPriorityL() {
		return priorityL;
	}

	public void setPriorityL(char priorityL) {
		this.priorityL = priorityL;
	}

}

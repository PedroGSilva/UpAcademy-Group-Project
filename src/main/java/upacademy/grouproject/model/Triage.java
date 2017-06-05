package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import upacademy.grouproject.model.Patient;

@Entity
public class Triage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	// Patient
	private Patient patientNHSCN;
	// Priority level
	private char priorityLevel;

	
	
	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Patient getPatientNHSCN() {
		return patientNHSCN;
	}

	public void setPatientNHSCN(Patient patientNHSCN) {
		this.patientNHSCN = patientNHSCN;
	}

	public char getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(char priorityLevel) {
		this.priorityLevel = priorityLevel;
	}

}

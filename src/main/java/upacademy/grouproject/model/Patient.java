package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	// National Health Service Card Number
	private Long nHSCnumber;
	// Patient name
	private String name;
	// Patient address
	private String adress;
	// Patient blood type
	private String bloodType;

	// Empty patient constructor
	public Patient() {

	}

	// Getters & Setters

	public Long getnHSCnumber() {
		return nHSCnumber;
	}

	public void setnHSCnumber(Long nHSCnumber) {
		this.nHSCnumber = nHSCnumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

}

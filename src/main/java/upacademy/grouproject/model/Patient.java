package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="PATIENT_ID")
	private Long ID;

	// Getters & Setters
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}
	
	
	// National Health Service Card Number
	@Size(min = 1, message = "Please insert a NHS card number")
	private String nHS;
	// Patient name
	@Size(min = 1, message = "Please insert a name")
	private String name;
	// Patient blood type
	@NotNull(message = "Please insert a blood type")
	private String bloodType;
	// Patient date of birth
	@Size(min = 1, message = "Please insert a date of birth")
	private String dateOfBirth;
	@NotNull(message = "Please specify a gender")
	private String gender;
	// Patient phone (city)
	@Size(min = 1, message = "Please insert a phone number")
	private String phone;
	// Patient Email (city)
	@Size(min = 1, message = "Please insert a town hall")
	private String email;
	// Patient street
	@Size(min = 1, message = "Please insert a street")
	private String street;
	// Patient door number and floor
	@Size(min = 1, message = "Please insert a floor number")
	private String numFloor;
	// Patient zipCode
	@Size(min = 1, message = "Please insert ZIP code")
	private String zipCode;
	// Patient town
	@Size(min = 1, message = "Please insert a town")
	private String town;
	// Optional Observations; no validation required
	private String observations;

	// Getters & Setters
	public String getnHS() {
		return nHS;
	}

	public void setnHS(String nHS) {
		this.nHS = nHS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumFloor() {
		return numFloor;
	}

	public void setNumFloor(String numFloor) {
		this.numFloor = numFloor;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

}

package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Patient extends EntityModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// National Health Service Card Number
	private int nHS;
	// Patient name
	private String name;
	// Patient blood type
	private String bloodType;
	// Patient date of birth
	private String dateofbirth;
	// Patient district (city)
	private String adddistrict;
	// Patient twon hall (city)
	private String addtownhall;
	// Patient street
	private String addstreet;
	// Patient door number and floor
	private String addnumfloor;
	// Patient zipcode
	private String addzipcode;
	// Patient twon
	private String addtown;

	// Empty patient constructor
	public Patient() {
	}

	// Getters & Setters

	public int getnHS() {
		return nHS;
	}

	public void setnHS(int nHS) {
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

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getAdddistrict() {
		return adddistrict;
	}

	public void setAdddistrict(String adddistrict) {
		this.adddistrict = adddistrict;
	}

	public String getAddtownhall() {
		return addtownhall;
	}

	public void setAddtownhall(String addtownhall) {
		this.addtownhall = addtownhall;
	}

	public String getAddstreet() {
		return addstreet;
	}

	public void setAddstreet(String addstreet) {
		this.addstreet = addstreet;
	}

	public String getAddnumfloor() {
		return addnumfloor;
	}

	public void setAddnumfloor(String addnumfloor) {
		this.addnumfloor = addnumfloor;
	}

	public String getAddzipcode() {
		return addzipcode;
	}

	public void setAddzipcode(String addzipcode) {
		this.addzipcode = addzipcode;
	}

	public String getAddtown() {
		return addtown;
	}

	public void setAddtown(String addtown) {
		this.addtown = addtown;
	}

}

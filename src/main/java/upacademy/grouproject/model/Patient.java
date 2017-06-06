package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long ID;
	// National Health Service Card Number
	private Long nHS;
	// Patient name
	private String name;
	// Patient address
	private String adress;
	// Patient blood type
	private String bloodType;
	// Patient date of birth
	private Long dateofbirth;
	// Patient district (city)
	private String adddistrict;
	// Patient twon hall (city)
	private String addtownhall;
	// Patient street
	private String addstreet;
	// Patient door number and floor
	private Long addnumfloor;
	// Patient zipcode
	private Long addzipcode;
	// Patient twon
	private Long addtown;
	
	// Empty patient constructor
	public Patient() {
	}

	// Getters & Setters

	public Long getnHS() {
		return nHS;
	}

	public void setnHS(Long nHS) {
		this.nHS = nHS;
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
	
	public Long getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Long dateofbirth) {
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

	public Long getAddnumfloor() {
		return addnumfloor;
	}

	public void setAddnumfloor(Long addnumfloor) {
		this.addnumfloor = addnumfloor;
	}

	public Long getAddzipcode() {
		return addzipcode;
	}

	public void setAddzipcode(Long addzipcode) {
		this.addzipcode = addzipcode;
	}

	public Long getAddtown() {
		return addtown;
	}

	public void setAddtown(Long addtown) {
		this.addtown = addtown;
	}

}

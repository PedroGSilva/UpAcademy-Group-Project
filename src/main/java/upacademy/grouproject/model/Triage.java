package upacademy.grouproject.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Triage extends EntityModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//Patient associated
	@ManyToOne(targetEntity = Patient.class,cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private Patient patient;

	// Priority level
	private char priorityLevel;
	
	
	// Set priority
	public char priorityLevel(Triage triage){
		char pl;
				
		if (selectedQuestionsRed != "[]"){
			pl = 'A';
		}
		else if (selectedQuestionsOrange != "[]"){
			pl = 'B';
		}
		else if (selectedQuestionsYellow != "[]"){
			pl = 'C';
		}
		else if (selectedQuestionsGeneral != "[]"){
			pl = 'D';
		}
		else {
			pl = 'E';
		}
		triage.setPriorityLevel(pl);
	return pl;
	}
	
	// Selected questions from the form
	private String selectedQuestionsRed = null;
	private String selectedQuestionsOrange = null;
	private String selectedQuestionsYellow = null;
	private String selectedQuestionsGeneral = null;
	
	// Getters & Setters
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public char getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(char priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	
	public ArrayList<String> getSelectedQuestionsRed() {

		ArrayList<String>  testered = new ArrayList<String>();
		if(selectedQuestionsRed != null && selectedQuestionsRed != ""){
			String[] selectedQuestionsRedParts = selectedQuestionsRed.split(",");
			for (String part : selectedQuestionsRedParts){
				testered.add(String.valueOf(part));
			}
		}
		return testered;
	}	

	public void setSelectedQuestionsRed(ArrayList<String> selectedQuestionsRed) {
		this.selectedQuestionsRed = selectedQuestionsRed.toString();
	}

	
	public ArrayList<String> getSelectedQuestionsOrange() {

		ArrayList<String>  testeorange = new ArrayList<String>();
		if(selectedQuestionsOrange != null && selectedQuestionsOrange != ""){
			String[] selectedQuestionsOrangeParts = selectedQuestionsOrange.split(",");
			for (String part : selectedQuestionsOrangeParts){
				testeorange.add(String.valueOf(part));
			}
		}
		return testeorange;
	}	

	public void setSelectedQuestionsOrange(ArrayList<String> selectedQuestionsOrange) {
		this.selectedQuestionsOrange = selectedQuestionsOrange.toString();
	}

	
	public ArrayList<String> getSelectedQuestionsYellow() {

		ArrayList<String>  testeyellow = new ArrayList<String>();
		if(selectedQuestionsYellow != null && selectedQuestionsYellow != ""){
			String[] selectedQuestionsYellowParts = selectedQuestionsYellow.split(",");
			for (String part : selectedQuestionsYellowParts){
				testeyellow.add(String.valueOf(part));
			}
		}
		return testeyellow;
	}	

	public void setSelectedQuestionsYellow(ArrayList<String> selectedQuestionsYellow) {
		this.selectedQuestionsYellow = selectedQuestionsYellow.toString();
	}

	
	public ArrayList<String> getSelectedQuestionsGeneral() {

		ArrayList<String>  testegeneral = new ArrayList<String>();
		if(selectedQuestionsGeneral != null && selectedQuestionsGeneral != ""){
			String[] selectedQuestionsGeneralParts = selectedQuestionsGeneral.split(",");
			for (String part : selectedQuestionsGeneralParts){
				testegeneral.add(String.valueOf(part));
			}
		}
		return testegeneral;
	}	

	public void setSelectedQuestionsGeneral(ArrayList<String> selectedQuestionsGeneral) {
		this.selectedQuestionsGeneral = selectedQuestionsGeneral.toString();
	}
	
}

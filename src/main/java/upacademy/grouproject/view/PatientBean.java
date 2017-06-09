package upacademy.grouproject.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Team;
import upacademy.grouproject.service.PatientService;

@Named("patientBean")
@RequestScoped
public class PatientBean {
	
	private Patient patient = new Patient();
	
	// Empty patient constructor
	public Patient getPatient() {
		return patient;
	}
	
	private Patient selectedPatient;
	
	@Inject
	private PatientService patientService;

	// Getters & Setters
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public Patient getSelectedPatient() {
		return selectedPatient;
	}

	public void setSelectedPatient(Patient selectedPatient) {
		this.selectedPatient = selectedPatient;
	}
	
	public Class<Patient> teste1(){
		return Patient.class;
		
	}

}

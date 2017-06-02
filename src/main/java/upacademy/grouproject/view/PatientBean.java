package upacademy.grouproject.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.service.PatientService;

@Named("patientBean")
@RequestScoped
public class PatientBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Patient patient = new Patient();

	@Inject
	private PatientService patientService;

	
	// Getters & Setters
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public PatientService getPatientService() {
		return patientService;
	}

	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}

}

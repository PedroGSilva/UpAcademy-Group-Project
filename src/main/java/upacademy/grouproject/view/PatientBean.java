package upacademy.grouproject.view;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.service.PatientService;
import java.io.Serializable;

@Named("patientBean")
@SessionScoped
public class PatientBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Patient patient = new Patient();

	// Empty patient constructor
	public Patient getPatient() {
		return patient;
	}


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

	public Class<Patient> teste1() {
		return Patient.class;

	}

}

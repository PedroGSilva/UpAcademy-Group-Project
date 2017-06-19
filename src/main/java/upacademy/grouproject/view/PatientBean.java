package upacademy.grouproject.view;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

	public void patientCheck(String nHS) {
		if (patientService.checkNHS(nHS) == true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Info", "Patient does not exist"));
			showcreate("show");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
					"Patient already exists"));
			showproceed("show");
		}

	}

	// Buttons show/hide
	private boolean showCreatePatient = false;
	private boolean showProceedTriage = false;

	public void showcreate(String state) {
		if (state == "show") {
			showCreatePatient = true;
		} else {
			showCreatePatient = false;
		}
	}

	public void showproceed(String state) {
		if (state == "show") {
			showProceedTriage = true;
		} else {
			showProceedTriage = false;
		}
	}

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

	public boolean isShowCreatePatient() {
		return showCreatePatient;
	}

	public void setShowCreatePatient(boolean showCreatePatient) {
		this.showCreatePatient = showCreatePatient;
	}

	public boolean isShowProceedTriage() {
		return showProceedTriage;
	}

	public void setShowProceedTriage(boolean showProceedTriage) {
		this.showProceedTriage = showProceedTriage;
	}

}

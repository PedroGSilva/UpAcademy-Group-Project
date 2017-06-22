package upacademy.grouproject.view;

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

	// Create patient
	public String patientCreate(Patient patient, String nextpage) {
		if (patientService.checkNHS(patient.getnHS()) == true) {
			patientService.addEntity(patient);
			newBean();
			return nextpage;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info: Patient already exists, please verify NHS number", ""));
		}
		return null;
	}

	// Delete patient
	public void deletePatient(Long ID) {
		patientService.deleteEntity(ID, Patient.class);
		newBean();
	}

	// Update patient
	public void updatePatient(Long ID, Patient patient) {
		patientService.mergePatient(ID, patient);
		newBean();
	}

	// New bean
	public void newBean() {
		this.patient = new Patient();
	}

	// Patient check in create ticket
	public void patientCheck(String nHS) {
		if (patientService.checkNHS(nHS) == true) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Info: Patient does not exist", ""));
			showcreate("show");
			showproceed("hide");
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info: Patient already exists", ""));
			showproceed("show");
			showcreate("hide");
		}
	}

	// Buttons show/hide
	private boolean showCreatePatient;
	private boolean showProceedTriage;

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

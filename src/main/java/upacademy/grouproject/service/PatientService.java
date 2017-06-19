package upacademy.grouproject.service;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Triage;
import upacademy.grouproject.repository.PatientRepository;
import upacademy.grouproject.view.PatientBean;
import upacademy.grouproject.view.TriageBean;

@Named("patientService")
@RequestScoped
public class PatientService extends EntityService<Patient> {

	@Inject
	PatientRepository er = new PatientRepository();

	@Inject
	PatientBean patient;

	// Add new Patient
	public String newPatient(Patient patient, String nextpage) {
		er.persistEntity(patient);
		newBean();
		return nextpage;
	}

	// Edit patient
	public void mergePatient(Long ID, Patient patient) {
		// Find patient in the database
		Patient emp = er.findEntity(Patient.class, ID);

		emp.setnHS(patient.getnHS());
		emp.setName(patient.getName());
		emp.setBloodType(patient.getBloodType());
		emp.setDateOfBirth(patient.getDateOfBirth());
		emp.setDistrict(patient.getDistrict());
		emp.setTownHall(patient.getTownHall());
		emp.setStreet(patient.getStreet());
		emp.setNumFloor(patient.getNumFloor());
		emp.setZipCode(patient.getZipCode());
		emp.setTown(patient.getTown());
		
		// Merge the new patient to the database
		er.mergeEntity(emp);
		newBean();
	
	}

	// Check if patient exists
	public boolean checkNHS(String nHS) {
		if (er.checkIfExists(nHS).isEmpty() == true) {
			return true;
		} else {
			return false;
		}
	}

	// New bean
	public void newBean() {
		this.patient.setPatient(new Patient());
	}
}

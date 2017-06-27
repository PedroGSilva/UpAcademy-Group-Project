package upacademy.grouproject.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Triage;
import upacademy.grouproject.repository.PatientRepository;
import upacademy.grouproject.repository.TriageRepository;

@Named("patientService")
@RequestScoped
public class PatientService extends EntityService<Patient> {

	@Inject
	PatientRepository er = new PatientRepository();

	// Edit patient
	public void mergePatient(Long ID, Patient patient) {
		// Find patient in the database
		Patient emp = er.findEntity(Patient.class, ID);

		emp.setnHS(patient.getnHS());
		emp.setName(patient.getName());
		emp.setBloodType(patient.getBloodType());
		emp.setDateOfBirth(patient.getDateOfBirth());
		emp.setGender(patient.getGender());
		emp.setPhone(patient.getPhone());
		emp.setEmail(patient.getEmail());
		emp.setStreet(patient.getStreet());
		emp.setNumFloor(patient.getNumFloor());
		emp.setZipCode(patient.getZipCode());
		emp.setTown(patient.getTown());
		emp.setObservations(patient.getObservations());

		// Merge the new patient to the database
		er.mergeEntity(emp);
	}

	// Check if patient exists
	public boolean checkNHS(String nHS) {
		if (er.checkIfExists(nHS).isEmpty() == true) {
			return true;
		} else {
			return false;
		}
	}

	// Get patient for triage
	public List<Patient> retrievePatient(String nHS) {
		return er.checkIfExists(nHS);
	}
	
	public List<Patient> patientFromLastID() {
		PatientRepository patfromlastID = (PatientRepository) this.er;
		return patfromlastID.returnPatientFromLastID();
	}

}

package upacademy.grouproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import upacademy.grouproject.model.Patient;
import upacademy.grouproject.repository.PatientRepository;

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

}

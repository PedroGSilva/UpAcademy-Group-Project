package upacademy.grouproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.repository.PatientRepository;
import upacademy.grouproject.view.PatientBean;

@Named("patientService")
@RequestScoped
public class PatientService extends EntityService<Patient> {

	@Inject
	PatientRepository er = new PatientRepository();

	@Inject
	PatientBean patient;

	// Edit patient
	@Transactional
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

	public String newPatient(Patient patient, String nextpage) {
		er.persistEntity(patient);
		newBean();
		return nextpage;
	}

	public void newBean() {
		this.patient.setPatient(new Patient());
	}

}

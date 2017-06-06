package upacademy.grouproject.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;

@Named("patientService")
@Transactional
@RequestScoped
public class PatientService implements Serializable {
	private static final long serialVersionUID = 1L;

	// unitName defined in persistence.xml
	@PersistenceContext(name = "database")
	static EntityManager em;

	// Add patient to database
	public void createPatient(Patient patient) {
		em.persist(patient);
	}

	// Remove patient from database
	public void removePatient(Long nHSCnumber) {
		Patient patientremove = em.find(Patient.class, nHSCnumber);
		em.remove(patientremove);
	}
	
	// Edit patient merge to database
	public void editPatient(Long nHSCnumber) {
		Patient patientedit = em.find(Patient.class, nHSCnumber);
		em.merge(patientedit);
	}
	
}

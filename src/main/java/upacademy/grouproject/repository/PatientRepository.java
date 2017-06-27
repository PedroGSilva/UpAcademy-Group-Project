package upacademy.grouproject.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;

@Named("patientRepository")
@Transactional
@ApplicationScoped
public class PatientRepository extends EntityRepository<Patient> {

	// unitName defined in persistence.xml
	@PersistenceContext(name = "database")
	static EntityManager em;

	public List<Patient> checkIfExists(String nHS) {
		List<Patient> query = em.createQuery("SELECT e FROM Patient e where nHS = " + nHS, Patient.class).getResultList();
		return query;
	}
	public List<Patient> returnPatientFromLastID() {
		List<Patient> patientlastID = em.createQuery("Select e from Patient e order by e.ID desc", Patient.class).getResultList();
		return patientlastID;
	}
}
package upacademy.grouproject.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Triage;

@Named("patientRepository")
@Transactional
@ApplicationScoped
public class PatientRepository extends EntityRepository<Patient> {

	// unitName defined in persistence.xml
	@PersistenceContext(name = "database")
	static EntityManager em;

	public List<Patient> checkIfExists(String nHS) {
		Query query = em.createQuery("SELECT e FROM Patient e where nHS = " + nHS);
		return query.getResultList();
	}
	public List<Patient> returnPatientFromLastID() {
		List<Patient> patientlastID = em.createQuery("Select e from Patient e order by e.ID desc").getResultList();

		return patientlastID;
	}
}
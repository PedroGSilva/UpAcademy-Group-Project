package upacademy.grouproject.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Triage;

@Named("triageRepository")
@Transactional
@RequestScoped
public class TriageRepository extends EntityRepository<Triage> {

	public List<Triage> returnsortTriage() {
		List<Triage> sorttriage = em.createQuery("Select e from Triage e order by e.priorityLevel asc").getResultList();

		return sorttriage;
	}
	
	// Get patient from database with nHS
	public Patient findPatient (String nHS) {
		Query query = em.createQuery("SELECT e FROM Patient e where nHS = " + nHS);
		return (Patient) query.getResultList().get(0);
	}

}
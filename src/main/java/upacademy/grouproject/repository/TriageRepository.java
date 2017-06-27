package upacademy.grouproject.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Triage;
import upacademy.grouproject.model.TriageHistoric;

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
	
	public List<Integer> listSizes () {
		List<Triage> ticketsA = em.createQuery("SELECT e FROM Triage e WHERE e.priorityLevel='A'").getResultList();
		List<Triage> ticketsB = em.createQuery("SELECT e FROM Triage e WHERE e.priorityLevel='B'").getResultList();
		List<Triage> ticketsC = em.createQuery("SELECT e FROM Triage e WHERE e.priorityLevel='C'").getResultList();
		List<Triage> ticketsD = em.createQuery("SELECT e FROM Triage e WHERE e.priorityLevel='D'").getResultList();
		List<Triage> ticketsE = em.createQuery("SELECT e FROM Triage e WHERE e.priorityLevel='E'").getResultList();
		
		List<Integer> TicketsCount = new ArrayList<Integer>();
		TicketsCount.add(ticketsA.size());
		TicketsCount.add(ticketsB.size());
		TicketsCount.add(ticketsC.size());
		TicketsCount.add(ticketsD.size());
		TicketsCount.add(ticketsE.size());
		TicketsCount.add(returnsortTriage().size());
		return TicketsCount;
	}

}
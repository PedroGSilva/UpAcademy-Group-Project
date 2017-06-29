package upacademy.grouproject.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
		List<Triage> sorttriage = em.createQuery("Select e from Triage e order by e.priorityLevel asc", Triage.class).getResultList();

		return sorttriage;
	}
	
	// Get patient from database with nHS
	public Patient findPatient (String nHS) {
		Query query = em.createQuery("SELECT e FROM Patient e where nHS = " + nHS);
		return (Patient) query.getResultList().get(0);
	}
	
	public List<Integer> listSizes () {
		String query = "SELECT (SELECT COUNT(*) FROM Triage WHERE priorityLevel like \"A\") AS 'countA', (SELECT COUNT(*) FROM Triage WHERE priorityLevel like \"B\") AS 'countB', (SELECT COUNT(*) FROM Triage WHERE priorityLevel like \"C\") AS 'countC', (SELECT COUNT(*) FROM Triage WHERE priorityLevel like \"D\") AS 'countD', (SELECT COUNT(*) FROM Triage WHERE priorityLevel like \"E\") AS 'countE' from TriageHistoric group by 1";

		List<Object[]> countersList = em.createNativeQuery(query).getResultList();
		List<Integer> calling = new ArrayList<Integer>();

		for (Object[] t : countersList) {
			for (Object t2 : t) {
				calling.add(Integer.parseInt(t2.toString()));
			}
		}
		int total = calling.stream().mapToInt(Integer::intValue).sum();
		calling.add(total);
		return calling;
	}
}
package upacademy.grouproject.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.TriageHistoric;

@Named("triageHistoricRepository")
@Transactional
@ApplicationScoped
public class TriageHistoricRepository extends EntityRepository<TriageHistoric> {

	public TriageHistoric returnLastEntry() {
		List<TriageHistoric> getlast = em.createQuery("SELECT e from TriageHistoric e order by e.ID desc")
				.getResultList();
		return (TriageHistoric) getlast.get(0);
	}

	public List<Integer> listSizes() {
		List<TriageHistoric> ticketsA = em.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='A'")
				.getResultList();
		List<TriageHistoric> ticketsB = em.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='B'")
				.getResultList();
		List<TriageHistoric> ticketsC = em.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='C'")
				.getResultList();
		List<TriageHistoric> ticketsD = em.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='D'")
				.getResultList();
		List<TriageHistoric> ticketsE = em.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='E'")
				.getResultList();

		List<Integer> calledTicketsCount = new ArrayList<Integer>();
		calledTicketsCount.add(ticketsA.size());
		calledTicketsCount.add(ticketsB.size());
		calledTicketsCount.add(ticketsC.size());
		calledTicketsCount.add(ticketsD.size());
		calledTicketsCount.add(ticketsE.size());
		return calledTicketsCount;
	}

}

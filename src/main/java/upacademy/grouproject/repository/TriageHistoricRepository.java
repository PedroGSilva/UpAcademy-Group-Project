package upacademy.grouproject.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.TriageHistoric;

@Named("triageHistoricRepository")
@Transactional
@ApplicationScoped
public class TriageHistoricRepository extends EntityRepository<TriageHistoric> {

	public TriageHistoric returnLastEntry() {
		List<TriageHistoric> getlast = em
				.createQuery("SELECT e from TriageHistoric e order by e.ID desc", TriageHistoric.class).getResultList();
		return (TriageHistoric) getlast.get(0);
	}

	public List<Integer> listSizes() {
		List<TriageHistoric> ticketsA = em
				.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='A'", TriageHistoric.class)
				.getResultList();
		List<TriageHistoric> ticketsB = em
				.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='B'", TriageHistoric.class)
				.getResultList();
		List<TriageHistoric> ticketsC = em
				.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='C'", TriageHistoric.class)
				.getResultList();
		List<TriageHistoric> ticketsD = em
				.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='D'", TriageHistoric.class)
				.getResultList();
		List<TriageHistoric> ticketsE = em
				.createQuery("SELECT e FROM TriageHistoric e WHERE e.priorityL='E'", TriageHistoric.class)
				.getResultList();

		List<Integer> calledTicketsCount = new ArrayList<Integer>();
		calledTicketsCount.add(ticketsA.size());
		calledTicketsCount.add(ticketsB.size());
		calledTicketsCount.add(ticketsC.size());
		calledTicketsCount.add(ticketsD.size());
		calledTicketsCount.add(ticketsE.size());
		return calledTicketsCount;
	}

//	// Test ---------------------------------------------------------------
//	public List<Integer> dbPrioSize() {
//		System.out.println("correu repo");
//		String str = "SELECT (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"A\") AS 'Count A', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"B\") AS 'Count B', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"C\") AS 'Count C', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"D\") AS 'Count D', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"E\") AS 'Count E' from TriageHistoric group by 1";
//		System.out.println("correu repo1");
//		List<Integer> test = em.createNativeQuery(str, Integer.class).getResultList();
//
//		System.out.println("correu repo2");
//		List<Integer> called = new ArrayList<Integer>();
//		called.add(test.get(0));
//		System.out.println("correu repo3");
//		called.add(test.get(1));
//		called.add(test.get(2));
//		called.add(test.get(3));
//		called.add(test.get(4));
//
//		return called;
//	}

}

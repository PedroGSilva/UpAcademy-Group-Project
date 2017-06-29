package upacademy.grouproject.repository;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;

import upacademy.grouproject.model.TriageHistoric;

@Named("triageHistoricRepository")
@Transactional
@ApplicationScoped
public class TriageHistoricRepository extends EntityRepository<TriageHistoric> {

	public List<TriageHistoric> returnLastEntry() {
		List<TriageHistoric> getlast = em
				.createQuery("SELECT e from TriageHistoric e order by e.ID desc", TriageHistoric.class).getResultList();
		List<TriageHistoric>  nowPrevTickets = new ArrayList<TriageHistoric>();
		nowPrevTickets.add(getlast.get(0));
		nowPrevTickets.add(getlast.get(1));
		return nowPrevTickets;
	}

	public List<Integer> countSize() {
		String str = "SELECT (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"A\") AS 'countA', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"B\") AS 'countB', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"C\") AS 'countC', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"D\") AS 'countD', (SELECT COUNT(*) FROM TriageHistoric WHERE priorityL like \"E\") AS 'countE' from TriageHistoric group by 1";

		List<Object[]> test = em.createNativeQuery(str).getResultList();
		List<Integer> called = new ArrayList<Integer>();

		for (Object[] t : test) {
			for (Object t2 : t) {
				called.add(Integer.parseInt(t2.toString()));
			}
		}

		return called;
	}

}

package upacademy.grouproject.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Triage;
import upacademy.grouproject.model.TriageHistoric;
import upacademy.grouproject.repository.TriageHistoricRepository;

@Named("triageHistoricService")
@RequestScoped
public class TriageHistoricService extends EntityService<TriageHistoric> {

	@Inject
	TriageHistoricRepository thr;

	public void addTriageHistoric(Triage triage) {
		TriageHistoric oldTicket = new TriageHistoric();

		oldTicket.setPatient(triage.getPatient());
		oldTicket.setPriorityL(triage.getPriorityLevel());
		thr.persistEntity(oldTicket);
	}

	public List<TriageHistoric> getCalledTicket() {
		return thr.returnLastEntry();
	}

	public List<Integer> countTickets() {
		return thr.countSize();
	}
}

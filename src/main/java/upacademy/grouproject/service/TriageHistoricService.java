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
	TriageHistoricRepository thr = new TriageHistoricRepository();
	
	public void addTriageHistoric (Triage triage) {
		TriageHistoric oldTicket = new TriageHistoric();
		
		oldTicket.setNameP(triage.getPatient().getName());
		oldTicket.setPriorityL(triage.getPriorityLevel());
		thr.persistEntity(oldTicket);
	}
	
	public TriageHistoric getCalledTicket (){
		return thr.returnLastEntry();
	}
	
	
	public List<Integer> countCalledTickets () {
		return thr.listSizes();
	}
	
//	//Test --------------
//	public List<Integer> testcount () {
//		System.out.println("correu service");
//		return thr.dbPrioSize();
//	}
}

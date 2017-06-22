package upacademy.grouproject.service;

import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Questions;
import upacademy.grouproject.model.Triage;
import upacademy.grouproject.repository.QuestionRepository;
import upacademy.grouproject.repository.TriageRepository;
import upacademy.grouproject.view.TriageBean;

import java.util.List;

import javax.enterprise.context.RequestScoped;

@Named("triageService")
@RequestScoped
public class TriageService extends EntityService<Triage>{
	// Not finished yet, needs testing and needs to be adapted to the new architecture --> IMPORTANT
	
	//Sort Triage on database (simple, based on priority only)
/*	public List <Triage> priorityLine () {
		Query query = em.createQuery("SELECT e FROM TRIAGE e"); // 
		List <Triage> triageList = query.getResultList();
		
		//List <Triage> sortedList = triageList.sort((Triage o1, Triage o2) -> o1.getPriorityLevel().compareTo(o2.getPriorityLevel()));
		List <Triage> sortedList2 = triageList.stream().sorted().collect(Collectors.toList());
		return sortedList2;
	}*/
	
	
	
	@Inject
	TriageRepository tr = new TriageRepository();
	
	@Inject
	TriageBean triage;
	
	public void newTicket(Triage triage, Patient patient) {
		triage.setnHS(patient.getnHS());
		triage.priorityLevel(triage);
		tr.persistEntity(triage);
		System.out.println(triage.getPriorityLevel());
		newBean();
	}
	
	public void newBean() {
		this.triage.setTriage(new Triage());
	}

	public List<Triage> getSortTriage (){
		
		TriageRepository trisort = (TriageRepository)this.er;
		return trisort.sortTriage();
	}	
	
}
package upacademy.grouproject.service;

import javax.inject.Named;
import javax.persistence.Query;

import upacademy.grouproject.model.Triage;
import upacademy.grouproject.repository.TriageRepository;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

import upacademy.grouproject.model.Triage;

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
}
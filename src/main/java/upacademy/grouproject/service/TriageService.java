package upacademy.grouproject.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import upacademy.grouproject.model.Triage;

@Named("triageService")
@RequestScoped
public class TriageService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// unitName defined in persistence.xml
	@PersistenceContext(name="database")
	static EntityManager em;
	
	//Sort Triage on database (simple, based on priority only)
	public List <Triage> priorityLine () {
		Query query = em.createQuery("SELECT e FROM TRIAGE e"); // 
		List <Triage> triageList = query.getResultList();
		
		//List <Triage> sortedList = triageList.sort((Triage o1, Triage o2) -> o1.getPriorityLevel().compareTo(o2.getPriorityLevel()));
		List <Triage> sortedList2 = triageList.stream().sorted().collect(Collectors.toList());
		return sortedList2;
	}
}

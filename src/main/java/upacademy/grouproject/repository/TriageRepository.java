package upacademy.grouproject.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Triage;

@Named("triageRepository")
@Transactional
@RequestScoped
public class TriageRepository extends EntityRepository<Triage> {
	
	public List<Triage> sortTriage (){
		List<Triage> sorttriage = em.createQuery("Select e from Triage e order by e.priorityLevel asc").getResultList();
		
		return sorttriage;
	}

}
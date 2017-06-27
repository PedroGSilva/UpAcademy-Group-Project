package upacademy.grouproject.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Triage;
import upacademy.grouproject.repository.TriageRepository;

@Named("triageService")
@RequestScoped
public class TriageService extends EntityService<Triage> {

	@Inject
	TriageRepository tr = new TriageRepository();

	public void newTicket(Triage triage, String nHS) {
		// Get patient for triage
		Patient patientTriage = tr.findPatient(nHS);
		
		// Set attributes
		triage.setPatient(patientTriage);
		triage.priorityLevel(triage);
		tr.persistEntity(triage);
	}

	public List<Triage> sortTriage() {
		TriageRepository trisort = (TriageRepository) this.er;
		return trisort.returnsortTriage();
	}
	
	public List<Integer> countTickets () {
		return tr.listSizes();
	}
	

}
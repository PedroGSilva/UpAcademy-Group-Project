package upacademy.grouproject.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import upacademy.grouproject.model.Triage;

@Named("triageService")
@RequestScoped
public class TriageService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	// unitName defined in persistence.xml
	@PersistenceContext(name="database")
	static EntityManager em;
	
	//Ticket caller (simple, based on priority only)
	public Triage nextTicket () {
		
		return;
	}
}

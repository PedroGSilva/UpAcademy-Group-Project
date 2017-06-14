package upacademy.grouproject.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import upacademy.grouproject.model.Triage;
import upacademy.grouproject.service.TriageService;

@Named("triageBean")
@RequestScoped
public class TriageBean {

	private Triage triage = new Triage();

	// Empty triage constructor
	public Triage getTriage() {
		return triage;
	}

	private Triage selectedTriage;

	@Inject
	private TriageService triageService;


	// Getters & Setters
	public void setTriage(Triage triage) {
		this.triage = triage;
	}

	public TriageService getTriageService() {
		return triageService;
	}

	public void setTriageService(TriageService triageService) {
		this.triageService = triageService;
	}

	public Triage getSelectedTriage() {
		return selectedTriage;
	}

	public void setSelectedTriage(Triage selectedTriage) {
		this.selectedTriage = selectedTriage;
	}

	public Class<Triage> teste() {
		return Triage.class;

	}

}
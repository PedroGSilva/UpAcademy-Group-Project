package upacademy.grouproject.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Triage;
import upacademy.grouproject.service.TriageService;

@Named("triageBean")
@RequestScoped
public class TriageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Triage triage = new Triage();

	// Empty triage constructor
	public Triage getTriage() {
		return triage;
	}

	@Inject
	private TriageService triageService;

	// Create triage
	public void triageCreate(String nHS) {
		triageService.newTicket(triage, nHS);
		newBean();
	}

	// Delete triage
	public void deleteTriage(Long ID) {
		triageService.deleteEntity(ID, Triage.class);
		newBean();
	}

	// Sort triage
	public List<Triage> sortTickets() {
		return triageService.sortTriage();
	}

	// New triage bean
	public void newBean() {
		this.triage = new Triage();
	}

	// Buttons show/hide
	private boolean showCreatePatient = false;
	private boolean showProceedTriage = false;

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

	public Class<Triage> teste() {
		return Triage.class;

	}

	public boolean isShowCreatePatient() {
		return showCreatePatient;
	}

	public void setShowCreatePatient(boolean showCreatePatient) {
		this.showCreatePatient = showCreatePatient;
	}

	public boolean isShowProceedTriage() {
		return showProceedTriage;
	}

	public void setShowProceedTriage(boolean showProceedTriage) {
		this.showProceedTriage = showProceedTriage;
	}
}
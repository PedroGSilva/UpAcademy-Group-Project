package upacademy.grouproject.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Triage;
import upacademy.grouproject.model.TriageHistoric;
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

	@Inject
	private TriageHistoricBean triageHistoricBean;

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

	private List<Triage> ticketShow = new ArrayList<Triage>();

	private List<Integer> counters = new ArrayList<Integer>();

	// Dashboard Ticket Call
	public void callTicket() {
		if (triageService.consultEntity("Triage").size() == 0) {
			// Resolver
		} else {
			triageService.deleteEntity(ticketShow.get(0).getID(), Triage.class);
			triageHistoricBean.triageHistoricCreate(ticketShow.get(0));
			ticketShow.clear();
			counters.clear();
			showTickets();
			triageHistoricBean.callTicketPrev();
		}

	}

	// Dashboard ticket panel
	@PostConstruct
	public void showTickets() {
		if (triageService.consultEntity("Triage").size() == 0) {
			// Resolver
		} else {
			List<Triage> list = triageService.sortTriage();
			Triage now = list.get(0);
			Triage next = list.get(1);
			ticketShow.add(now);
			ticketShow.add(next);

			counters.add(triageService.countTickets().get(0));
			counters.add(triageService.countTickets().get(1));
			counters.add(triageService.countTickets().get(2));
			counters.add(triageService.countTickets().get(3));
			counters.add(triageService.countTickets().get(4));
			counters.add(triageService.countTickets().get(5));
		}

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

	public List<Triage> getTicketShow() {
		return ticketShow;
	}

	public void setTicketShow(List<Triage> ticketShow) {
		this.ticketShow = ticketShow;
	}

	public TriageHistoricBean getTriageHistoricBean() {
		return triageHistoricBean;
	}

	public void setTriageHistoricBean(TriageHistoricBean triageHistoricBean) {
		this.triageHistoricBean = triageHistoricBean;
	}

	public List<Integer> getCounters() {
		return counters;
	}

	public void setCounters(List<Integer> counters) {
		this.counters = counters;
	}
}
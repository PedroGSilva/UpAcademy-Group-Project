package upacademy.grouproject.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import upacademy.grouproject.model.Triage;
import upacademy.grouproject.model.TriageHistoric;
import upacademy.grouproject.service.TriageHistoricService;

@Named("triageHsitoricBean")
@RequestScoped
public class TriageHistoricBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TriageHistoric triageHistoric = new TriageHistoric();

	@Inject
	private TriageHistoricService triageHistoricService;

	// Create triage historic
	public void triageHistoricCreate(Triage triage) {
		triageHistoricService.addTriageHistoric(triage);
	}

	private List<TriageHistoric> previous = new ArrayList<TriageHistoric>();

	private List<Integer> counters = new ArrayList<Integer>();

	// Get called ticket
	@PostConstruct
	public void calledTicket() {
		previous.add(triageHistoricService.getCalledTicket());
		counters.add(triageHistoricService.countCalledTickets().get(0));
		counters.add(triageHistoricService.countCalledTickets().get(1));
		counters.add(triageHistoricService.countCalledTickets().get(2));
		counters.add(triageHistoricService.countCalledTickets().get(3));
		counters.add(triageHistoricService.countCalledTickets().get(4));

		calledPie = new PieChartModel();

		calledPie.set("Red", triageHistoricService.countCalledTickets().get(0));
		calledPie.set("Orange", triageHistoricService.countCalledTickets().get(1));
		calledPie.set("Yellow", triageHistoricService.countCalledTickets().get(2));
		calledPie.set("Green", triageHistoricService.countCalledTickets().get(3));
		calledPie.set("Blue", triageHistoricService.countCalledTickets().get(4));

		calledPie.setTitle("Called Tickets");
		calledPie.setLegendPosition("w");
	}

	public void callTicketPrev() {
		previous.clear();
		counters.clear();
		calledTicket();
		triageHistoricService.countCalledTickets();
	}

	// Pie Chart
	private PieChartModel calledPie;


	// Getters & Setters
	public TriageHistoric getTriageHistoric() {
		return triageHistoric;
	}

	public void setTriageHistoric(TriageHistoric triageHistoric) {
		this.triageHistoric = triageHistoric;
	}

	public TriageHistoricService getTriageHistoricService() {
		return triageHistoricService;
	}

	public void setTriageHistoricService(TriageHistoricService triageHistoricService) {
		this.triageHistoricService = triageHistoricService;
	}

	public List<TriageHistoric> getPrevious() {
		return previous;
	}

	public void setPrevious(List<TriageHistoric> previous) {
		this.previous = previous;
	}

	public List<Integer> getCounters() {
		return counters;
	}

	public void setCounters(List<Integer> counters) {
		this.counters = counters;
	}

	public PieChartModel getCalledPie() {
		return calledPie;
	}

	public void setCalledPie(PieChartModel calledPie) {
		this.calledPie = calledPie;
	}

}

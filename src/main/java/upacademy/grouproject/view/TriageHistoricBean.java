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
import upacademy.grouproject.service.TriageService;

@Named("triageHistoricBean")
@RequestScoped
public class TriageHistoricBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TriageHistoric triageHistoric = new TriageHistoric();

	@Inject
	private TriageHistoricService triageHistoricService;

	@Inject
	private TriageService triageService;

	// Create triage historic
	public void triageHistoricCreate(Triage triage) {
		triageHistoricService.addTriageHistoric(triage);
	}

	private List<Triage> nextTickets = new ArrayList<Triage>();

	private List<TriageHistoric> ticketHistory = new ArrayList<TriageHistoric>();

	private List<Integer> waitingRoom = new ArrayList<Integer>();

	List<Integer> calledTicketsCounter = new ArrayList<Integer>();

	// Pie Chart
	private PieChartModel calledPie;

	// Dashboard Ticket Call
	public void callTicket() {

		triageService.deleteEntity(nextTickets.get(0).getID(), Triage.class);
		triageHistoricCreate(nextTickets.get(0));

		TriageHistoric curretnTicket = new TriageHistoric();
		curretnTicket.setPatient(nextTickets.get(0).getPatient());
		curretnTicket.setPriorityL(nextTickets.get(0).getPriorityLevel());

		ticketHistory.add(0, curretnTicket);
		nextTickets.remove(0);
		refreshCounters();
		waitingRoom.add(5, waitingRoom.remove(5) - 1);
	}

	// Get called ticket
	@PostConstruct
	public void dashboardLoad() {
		// Add existing tickets
		List<Triage> list = triageService.sortTriage();
		nextTickets = list;

		// get last called
		List<TriageHistoric> lastCalled = triageHistoricService.getCalledTicket();
		ticketHistory = lastCalled;

		// Add waiting room counters
		List<Integer> nextCounter = triageService.countTickets();
		waitingRoom = nextCounter;

		List<Integer> calledCounter = triageHistoricService.countTickets();
		calledTicketsCounter = calledCounter;
		createPie();
	}

	public void createPie() {
		calledPie = new PieChartModel();
		calledPie.setSeriesColors("ff5f47,ff9a21,ffcf00,48b32e,428aca");
		calledPie.setLegendPosition("e");
		calledPie.setDiameter(450);

		calledPie.set("A tickets", calledTicketsCounter.get(0));
		calledPie.set("B tickets", calledTicketsCounter.get(1));
		calledPie.set("C tickets", calledTicketsCounter.get(2));
		calledPie.set("D tickets", calledTicketsCounter.get(3));
		calledPie.set("E tickets", calledTicketsCounter.get(4));
	}

	public void refreshCounters() {
		char nextTicket = ticketHistory.get(0).getPriorityL();
		if (nextTicket == 'A') {
			waitingRoom.add(0, waitingRoom.remove(0) - 1);
		} else if (nextTicket == 'B') {
			waitingRoom.add(1, waitingRoom.remove(1) - 1);
		} else if (nextTicket == 'C') {
			waitingRoom.add(2, waitingRoom.remove(2) - 1);
		} else if (nextTicket == 'D') {
			waitingRoom.add(3, waitingRoom.remove(3) - 1);
		} else {
			waitingRoom.add(4, waitingRoom.remove(4) - 1);
		}

	}

	// Dynamic CSS class
	public String getCurrentPriorityClass() {
		char currentTicketPrio = ticketHistory.get(0).getPriorityL();
		if (currentTicketPrio == 'A') {
			return "weather-3A";
		} else if (currentTicketPrio == 'B') {
			return "weather-3B";
		} else if (currentTicketPrio == 'C') {
			return "weather-3C";
		} else if (currentTicketPrio == 'D') {
			return "weather-3D";
		} else {
			return "weather-3E";
		}
	}

	public String getNextPriorityClass() {
		char nextTicketPrio = nextTickets.get(0).getPriorityLevel();
		if (nextTicketPrio == 'A') {
			return "weather-3A";
		} else if (nextTicketPrio == 'B') {
			return "weather-3B";
		} else if (nextTicketPrio == 'C') {
			return "weather-3C";
		} else if (nextTicketPrio == 'D') {
			return "weather-3D";
		} else {
			return "weather-3E";
		}
	}

	// Dynamic CSS class
	public String getHistoricPriorityClass() {
		char previousTicketPrio = ticketHistory.get(1).getPriorityL();
		if (previousTicketPrio == 'A') {
			return "weather-3A";
		} else if (previousTicketPrio == 'B') {
			return "weather-3B";
		} else if (previousTicketPrio == 'C') {
			return "weather-3C";
		} else if (previousTicketPrio == 'D') {
			return "weather-3D";
		} else {
			return "weather-3E";
		}
	}

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

	public PieChartModel getCalledPie() {
		return calledPie;
	}

	public void setCalledPie(PieChartModel calledPie) {
		this.calledPie = calledPie;
	}

	public TriageService getTriageService() {
		return triageService;
	}

	public void setTriageService(TriageService triageService) {
		this.triageService = triageService;
	}

	public List<Triage> getNextTickets() {
		return nextTickets;
	}

	public void setNextTickets(List<Triage> nextTickets) {
		this.nextTickets = nextTickets;
	}

	public List<TriageHistoric> getTicketHistory() {
		return ticketHistory;
	}

	public void setTicketHistory(List<TriageHistoric> ticketHistory) {
		this.ticketHistory = ticketHistory;
	}

	public List<Integer> getWaitingRoom() {
		return waitingRoom;
	}

	public void setWaitingRoom(List<Integer> counters) {
		this.waitingRoom = counters;
	}

}

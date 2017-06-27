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

@Named("triageHistoricBean")
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

	// Get called ticket
	@PostConstruct
	public void calledTicket() {
		previous.add(triageHistoricService.getCalledTicket());

		calledPie = new PieChartModel();

		calledPie.set("A tickets", triageHistoricService.countCalledTickets().get(0));
		calledPie.set("B tickets", triageHistoricService.countCalledTickets().get(1));
		calledPie.set("C tickets", triageHistoricService.countCalledTickets().get(2));
		calledPie.set("D tickets", triageHistoricService.countCalledTickets().get(3));
		calledPie.set("E tickets", triageHistoricService.countCalledTickets().get(4));
		calledPie.setSeriesColors("ff5f47,ff9a21,ffcf00,48b32e,428aca");
		calledPie.setLegendPosition("e");
		calledPie.setDiameter(450);
		
		
	}

	public void callTicketPrev() {
		previous.clear();
		calledTicket();
		triageHistoricService.countCalledTickets();
	}

	// Test
	// ---------------------------------------------------------------------------------
//	private PieChartModel pietest;
//
//	public PieChartModel getPietest() {
//		return pietest;
//	}
//
//	public void setPietest(PieChartModel pietest) {
//		this.pietest = pietest;
//	}
//
//	public void test() {
//		// Add previously called ticket -test
//		previous.add(triageHistoricService.getCalledTicket());
//
//		// New pie chart - test
//		pietest = new PieChartModel();
//		pietest.setSeriesColors("ff5f47,ff9a21,ffcf00,48b32e,428aca");
//		pietest.setLegendPosition("e");
//		pietest.setDiameter(450);
//
//		// Add data to pie chart -test
//		pietest.set("A tickets", triageHistoricService.testcount().get(0));
//		pietest.set("B tickets", triageHistoricService.testcount().get(1));
//		pietest.set("C tickets", triageHistoricService.testcount().get(2));
//		pietest.set("D tickets", triageHistoricService.testcount().get(3));
//		pietest.set("E tickets", triageHistoricService.testcount().get(4));
//	}

	// End test
	// ------------------------------------------------------------------------------

	// Dynamic CSS class
	public String getHistoricPriorityClass() {
		if (previous.get(0).getPriorityL() == 'A') {
			return "weather-3A";
		} else if (previous.get(0).getPriorityL() == 'B') {
			return "weather-3B";
		} else if (previous.get(0).getPriorityL() == 'C') {
			return "weather-3C";
		} else if (previous.get(0).getPriorityL() == 'D') {
			return "weather-3D";
		} else {
			return "weather-3E";
		}
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

	public PieChartModel getCalledPie() {
		return calledPie;
	}

	public void setCalledPie(PieChartModel calledPie) {
		this.calledPie = calledPie;
	}

}

package upacademy.grouproject.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.service.TeamService;

@Named("teamBean")
@RequestScoped
public class TeamBean {

	private Team team = new Team();

	// Empty team constructor
	public Team getTeam() {
		return team;
	}

	private Team selectedTeam;

	@Inject
	private TeamService teamService;


	// Getters & Setters
	public void setTeam(Team team) {
		this.team = team;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public Team getSelectedTeam() {
		return selectedTeam;
	}

	public void setSelectedTeam(Team selectedTeam) {
		this.selectedTeam = selectedTeam;
	}

	public Class<Team> teste() {
		return Team.class;

	}

}

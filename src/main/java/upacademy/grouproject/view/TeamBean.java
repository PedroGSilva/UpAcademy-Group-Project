package upacademy.grouproject.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.service.TeamService;

@Named("teamBean")
@RequestScoped
public class TeamBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Team team = new Team();

	// Empty team constructor
	public Team getTeam() {
		return team;
	}

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

	@Inject
	private TeamService teamService;

}

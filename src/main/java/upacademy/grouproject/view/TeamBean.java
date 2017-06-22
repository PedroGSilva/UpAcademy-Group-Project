package upacademy.grouproject.view;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.service.TeamService;
import java.io.Serializable;

@Named("teamBean")
@SessionScoped
public class TeamBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Team team = new Team();

	// Empty team constructor
	public Team getTeam() {
		return team;
	}

	@Inject
	private TeamService teamService;

	// Create team
	public String teamCreate (Team team, String nextpage) {
		teamService.addEntity(team);
		newBean();
		return nextpage;
	}
	
	// Delete team
	public void deleteTeam (Long ID) {
		teamService.deleteEntity(ID, Team.class);
		newBean();
	}
	
	// Update team 
	public void updateTeam (Long ID, Team team) {
		teamService.mergeTeam(ID, team);
		newBean();
	}
	
	// New team bean
	public void newBean() {
		this.team = new Team();
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

	public Class<Team> teste() {
		return Team.class;

	}

}

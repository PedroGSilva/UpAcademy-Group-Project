package upacademy.grouproject.view;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.service.TeamService;
import java.io.Serializable;
import java.util.Collection;

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
	public String teamCreate (String nextpage) {
		if (teamService.checkRoom(team) == true) {
			teamService.addEntity(team);
			newBean();
			return nextpage;
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Info: Room already occupied, please change room number", ""));
		}
		return null;
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
	
	// Consult all teams
	public Collection<Team> consultTeams (String entity) {
		return teamService.consultEntity(entity);
	}
	
	// Consult teams, order by priority
	public Collection<Team> consultTeamsByRoom () {
		return teamService.orderTeamByRoom();
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


}

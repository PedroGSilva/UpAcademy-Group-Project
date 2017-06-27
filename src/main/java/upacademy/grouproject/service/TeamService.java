package upacademy.grouproject.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.repository.TeamRepository;

@Named("teamService")
@RequestScoped
public class TeamService extends EntityService<Team> {

	@Inject
	TeamRepository er = new TeamRepository();

	//Team create and check if room is occupied
	public boolean checkRoom (Team team) {
		if (er.selectRoom(team.getTeamRoom()).isEmpty() == true) {
			return true;
		} else {
			return false;
		}
	}
	
	
	// Edit team
	public void mergeTeam(Long ID, Team team) {
		// Find the team in the database
		Team emp = er.findEntity(Team.class, ID);

		emp.setTeamName(team.getTeamName());
		emp.setProfNames(team.getProfNames());
		emp.setTeamPriority(team.getTeamPriority());
		emp.setTeamRoom(team.getTeamRoom());

		// Merge the new team to the database
		er.mergeEntity(emp);
	}
	
	public Collection<Team> orderTeamByRoom () {
		return er.returnTeamsByRoom();
	}

}

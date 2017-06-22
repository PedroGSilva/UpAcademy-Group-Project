package upacademy.grouproject.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.repository.TeamRepository;

@Named("teamService")
@RequestScoped
public class TeamService extends EntityService<Team> {

	@Inject
	TeamRepository er = new TeamRepository();

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

}

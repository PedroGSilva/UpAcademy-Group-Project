package upacademy.grouproject.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.enterprise.context.RequestScoped;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.repository.TeamRepository;
import upacademy.grouproject.view.TeamBean;

@Named("teamService")
@RequestScoped
public class TeamService extends EntityService<Team> {

	@Inject
	TeamRepository er = new TeamRepository();

	@Inject
	TeamBean team;

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
		newBean();
	}

	public String newTeam(Team team, String nextpage) {
		er.persistEntity(team);
		newBean();
		return nextpage;
	}

	public void newBean() {
		this.team.setTeam(new Team());
	}
}

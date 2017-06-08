package upacademy.grouproject.service;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import repository.TeamRepository;
import upacademy.grouproject.model.Team;

@Named("teamService")
@RequestScoped
public class TeamService {

	@Inject
	TeamRepository tr = new TeamRepository();

	// Add team to database
	public String createTeam(Team team, String nextpage) {
		tr.persistEntity(team);
		return nextpage;
	}

	public Collection<Team> consultTeam() {
		String team = "Team";
		return tr.returnEntities(team);
	}

	// Remove team from database
	public String deleteTeam(Long ID, String nextPage) {
		tr.removeEntity(Team.class, ID);
		return nextPage;
	}

	// Edit team merge to database
	public void editTeam(Long ID) {
		tr.mergeEntity(Team.class, ID);
	}

}

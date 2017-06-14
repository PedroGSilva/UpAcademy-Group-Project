package upacademy.grouproject.service;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.repository.TeamRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@Named("teamService")
@RequestScoped
public class TeamService extends EntityService<Team> {

	@Inject
	TeamRepository er = new TeamRepository();

	// Edit team
	@Transactional
	public void mergeTeam(Team team) {
		// Get the values from the inputs - needs validation!!
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String idString = request.getParameter("form:id");
		String teamName = request.getParameter("form:teamName");
		String profNames = request.getParameter("form:profNames");
		String teamPriority = request.getParameter("form:teamPriority");
		String teamRoomString = request.getParameter("form:teamRoom");

		// Needed conversions
		Long teamRoom = Long.parseLong(teamRoomString);
		Long id = Long.parseLong(idString);

		// Find the team on the database
		Team emp = er.findEntity(Team.class, id);

		// Set the new values
		emp.setTeamName(teamName);
		emp.setProfNames(profNames);
		emp.setTeamPriority(teamPriority);
		emp.setTeamRoom(teamRoom);

		// Merge the new team to the databse
		er.mergeEntity(emp);
	}
}

package upacademy.grouproject.repository;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Team;

@Named("teamRepository")
@Transactional
@ApplicationScoped
public class TeamRepository extends EntityRepository<Team> {


	// Consult teams order by priority (A>E)
	public Collection<Team> returnTeamsByRoom() {
		Collection<Team> sortById = em.createQuery("Select e from Team e order by e.teamRoom asc", Team.class).getResultList();
		return sortById;
	}
	
	public List<Team> selectRoom(Long teamRoom) {
		List<Team> query = em.createQuery("SELECT e FROM Team e where teamRoom = " + teamRoom, Team.class).getResultList();
		return query;
	}
}
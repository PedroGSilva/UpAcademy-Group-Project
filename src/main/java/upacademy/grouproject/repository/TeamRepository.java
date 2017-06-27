package upacademy.grouproject.repository;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Team;

@Named("teamRepository")
@Transactional
@ApplicationScoped
public class TeamRepository extends EntityRepository<Team> {


	// Consult teams order by priority (A>E)
	public Collection<Team> returnTeamsByRoom() {
		Collection<Team> sortById = em.createQuery("Select e from Team e order by e.teamRoom asc").getResultList();
		return sortById;
	}
	
	public List<Team> selectRoom(Long teamRoom) {
		Query query = em.createQuery("SELECT e FROM Team e where teamRoom = " + teamRoom);
		return query.getResultList();
	}
}
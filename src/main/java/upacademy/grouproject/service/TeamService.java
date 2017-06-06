package upacademy.grouproject.service;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Team;

@Named("teamService")
@Transactional
@RequestScoped
public class TeamService implements Serializable {
	private static final long serialVersionUID = 1L;

	// unitName defined in persistence.xml
	@PersistenceContext(name = "database")
	static EntityManager em;

	// Add team to database
	public String createTeam(Team team, String nextPage) {
		em.persist(team);
		return nextPage;
	}

	public Collection<Team> listTeams() {
		Query query = em.createQuery("SELECT e FROM Team e");
		return (Collection<Team>) query.getResultList();
	}

	// Remove team from database
	public String removeTeam(Long ID, String nextPage) {
		Team teamRemove = em.find(Team.class, ID);
		em.remove(teamRemove);
		return nextPage;
	}

	// Edit team merge to database
	public void editTeam(Long ID) {
		Team teamEdit = em.find(Team.class, ID);
		em.merge(teamEdit);
	}

}

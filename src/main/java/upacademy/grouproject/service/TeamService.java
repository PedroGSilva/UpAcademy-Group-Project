package upacademy.grouproject.service;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public void createTeam(Team team) {
		em.persist(team);
	}

	// Remove team from database
	public void removeTeam(Long ID) {
		Team teamRemove = em.find(Team.class, ID);
		em.remove(teamRemove);
	}

	// Edit team merge to database
	public void editTeam(Long ID) {
		Team teamEdit = em.find(Team.class, ID);
		em.merge(teamEdit);
	}

}

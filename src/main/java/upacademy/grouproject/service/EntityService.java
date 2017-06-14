package upacademy.grouproject.service;

import java.util.Collection;

import javax.inject.Inject;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.repository.EntityRepository;
import upacademy.grouproject.repository.TeamRepository;

public abstract class EntityService<T> {

	@Inject
	EntityRepository<T> er = new EntityRepository<T>();

	// Add entity to database
	public String createEntity(T ent, String nextpage) {
		er.persistEntity(ent);
		return nextpage;
	}

	// Consult existing entities
	public Collection<T> consultEntity(String querystring) {
		return er.returnEntities(querystring);
	}

	// Remove entity from database
	public String deleteEntity(Long ID, Class<T> ent, String nextPage) {
		er.removeEntity(ent, ID);
		System.out.println(nextPage);
		return nextPage;
	}

	// Merge entity to database - Don´t work yet
	public void editEntity(Class<T> ent, Long ID) {
		System.out.println("Chamou o edit");
		er.mergeEntity(ent, ID);
	}

}

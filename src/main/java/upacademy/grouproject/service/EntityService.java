package upacademy.grouproject.service;

import java.util.Collection;

import javax.inject.Inject;

import upacademy.grouproject.repository.EntityRepository;

public abstract class EntityService<T> {

	@Inject
	EntityRepository<T> er = new EntityRepository<T>();

	// Consult existing entities
	public Collection<T> consultEnity(String querystring) {
		return er.returnEntities(querystring);
	}

	// Remove entity from database
	public String deleteEntity(Long ID, Class<T> ent, String nextPage) {
		er.removeEntity(ent, ID);
		return nextPage;
	}

}

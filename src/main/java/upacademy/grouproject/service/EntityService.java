package upacademy.grouproject.service;

import java.util.Collection;

import javax.inject.Inject;

import upacademy.grouproject.repository.EntityRepository;

public abstract class EntityService<T> {

	@Inject
	EntityRepository<T> er = new EntityRepository<T>();

	// Add new entity to database
	public void addEntity (T entity) {
		er.persistEntity(entity);
	}
	
	// Consult existing entities
	public Collection<Object> consultEntity(String querystring) {
		return er.returnEntities(querystring);
	}

	// Remove entity from database
	public void deleteEntity(Long ID, Class<T> ent) {
		er.removeEntity(ent, ID);
	}

}

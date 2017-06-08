package repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class EntityRepository<T extends Object> {

	// unitName defined in persistence.xml
	@PersistenceContext(name = "database")
	static EntityManager em;

	// Add team to database
	public void persistEntity(T entity) {
		em.persist(entity);
	}

	public Collection<T> returnEntities(String entity) {
		Query query = em.createQuery("SELECT e FROM " + entity + " e");
		return (Collection<T>) query.getResultList();
	}

	// Remove team from database
	public void removeEntity(Class<T> c, Long ID) {
		Object entRemove = em.find(c, ID);
		em.remove(entRemove);
	}

	// Edit team merge to database
	public void mergeEntity(Class<T> c, Long ID) {
		Object entEdit = em.find(c, ID);
		em.merge(entEdit);
	}
}

package upacademy.grouproject.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class EntityRepository<T> {

	// unitName defined in persistence.xml
	@PersistenceContext(name = "database")
	static EntityManager em;

	// Add team to database
	public void persistEntity(T entity) {
		em.persist(entity);
	}

	public Collection<T> returnEntities(String entity) {
		Query query = em.createQuery("SELECT e FROM " + entity + " e");
		System.out.println("Chamou a lista");
		return (Collection<T>) query.getResultList();
	}

	// Find entity
	public T findEntity(Class<T> ent, Long ID) {
		T emp = em.find(ent, ID);
		return emp;
	}

	// Remove team from database
	public void removeEntity(Class<T> ent, Long ID) {
		Object entRemove = em.find(ent, ID);
		em.remove(entRemove);
	}

	// Edit team merge to database
	public void mergeEntity(T entity) {
		em.merge(entity);
	}
}
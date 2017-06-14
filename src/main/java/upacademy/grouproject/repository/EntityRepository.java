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
	
	public Object returnEntity(Class<T> c, Long ID) {
		Object entEdit = em.find(c, ID);
		return entEdit;
	}

	// Remove team from database
	public void removeEntity(Class<T> ent, Long ID) {
		Object entRemove = em.find(ent, ID);
		em.remove(entRemove);
	}

	// Edit team merge to database - Don't work yet
	public void mergeEntity(Class<T> ent, Long ID) {
		System.out.println("correu o edit");
		T emp =em.find(ent, ID);
		em.merge(emp);
	}
}
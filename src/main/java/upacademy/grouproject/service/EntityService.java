package upacademy.grouproject.service;

import java.util.Collection;

import javax.inject.Inject;

import upacademy.grouproject.repository.EntityRepository;


public abstract class EntityService <T extends Object> {
		
		@Inject
		EntityRepository<T> er = new EntityRepository<T>();
		
		// Add entity to database
		public String createEntity(T ent, String nextpage) {
			er.persistEntity(ent);
			return nextpage;
		}
		
		// Consult existing entities
		public Collection<T> consultEnity(String querystring) {
			return er.returnEntities(querystring);
		}

		// Remove entity from database
		public String deleteEntity(Long ID, Class<T> ent,String nextPage) {
			er.removeEntity(ent, ID);
			return nextPage;
			}

		// Merge entity to database - Don´t work yet
		public void editEdity(Long ID, Class<T> t) {
			er.mergeEntity(t, ID);
		}

	
}

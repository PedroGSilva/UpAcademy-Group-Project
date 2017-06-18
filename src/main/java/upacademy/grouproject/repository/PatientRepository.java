package upacademy.grouproject.repository;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;

@Named("patientRepository")
@Transactional
@ApplicationScoped
public class PatientRepository extends EntityRepository<Patient> {

	// unitName defined in persistence.xml
	@PersistenceContext(name = "database")
	static EntityManager em;

	public List<Patient> checkIfExists(String nHS) {
		Query query = em.createQuery("SELECT e FROM Patient e where nHS = " + nHS);
		return query.getResultList();

	}
}
package upacademy.grouproject.repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;

@Named("patientRepository")
@Transactional
@RequestScoped
public class PatientRepository extends EntityRepository<Patient> {

}

package upacademy.grouproject.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Patient;

@Named("patientRepository")
@Transactional
@ApplicationScoped
public class PatientRepository extends EntityRepository<Patient> {

}
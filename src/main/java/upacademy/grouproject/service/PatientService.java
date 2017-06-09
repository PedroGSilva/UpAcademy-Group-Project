package upacademy.grouproject.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import upacademy.grouproject.model.Patient;
import upacademy.grouproject.model.Team;

@Named("patientService")
@RequestScoped
public class PatientService extends EntityService<Patient> {

}

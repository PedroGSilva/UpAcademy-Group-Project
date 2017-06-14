package upacademy.grouproject.repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Triage;

@Named("triageRepository")
@Transactional
@RequestScoped
public class TriageRepository extends EntityRepository<Triage> {

}
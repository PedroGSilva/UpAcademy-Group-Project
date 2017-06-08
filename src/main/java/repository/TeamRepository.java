package repository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Team;

@Named("teamRepository")
@Transactional
@RequestScoped
public class TeamRepository extends EntityRepository<Team> {

}

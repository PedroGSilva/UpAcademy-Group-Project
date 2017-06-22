package upacademy.grouproject.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

import upacademy.grouproject.model.Team;

@Named("teamRepository")
@Transactional
@ApplicationScoped
public class TeamRepository extends EntityRepository<Team> {

}
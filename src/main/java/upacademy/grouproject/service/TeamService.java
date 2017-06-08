package upacademy.grouproject.service;

import javax.inject.Named;

import upacademy.grouproject.model.Team;
import javax.enterprise.context.Dependent;

@Named("teamService")
@Dependent
public class TeamService extends EntityService<Team>{


}

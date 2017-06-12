package upacademy.grouproject.service;

import javax.inject.Named;
import javax.persistence.Query;

import upacademy.grouproject.model.Team;
import upacademy.grouproject.repository.TeamRepository;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

@Named("teamService")
@RequestScoped
public class TeamService extends EntityService<Team>{


}

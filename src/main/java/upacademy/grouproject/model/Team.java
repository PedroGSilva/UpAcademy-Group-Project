package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Team extends EntityModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// Team name
	private String teamName;
	// Professionals on the team
	private String profNames;
	// Attended priority level
	private String teamPriority;
	// Team room
	private Long teamRoom;

	// Getters & Setters
	public String getTeamPriority() {
		return teamPriority;
	}

	public void setTeamPriority(String teamPriority) {
		this.teamPriority = teamPriority;
	}

	public Long getTeamRoom() {
		return teamRoom;
	}

	public void setTeamRoom(Long teamRoom) {
		this.teamRoom = teamRoom;
	}

	public String getProfNames() {
		return profNames;
	}

	public void setProfNames(String profNames) {
		this.profNames = profNames;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

}

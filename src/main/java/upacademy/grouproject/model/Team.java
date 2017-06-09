package upacademy.grouproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long ID;
	// Team name
	private String teamName;
	// Professionals on the team
	private String profNames;
	// Attended priority level
	private String teamPriority;
	// Team room
	private Long teamRoom;

	
	// Getters & Setters
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

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

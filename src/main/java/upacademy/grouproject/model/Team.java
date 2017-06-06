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
	// Professionals on the team
	private String profNames;
	// Attended priority level
	private char teamPriority;
	// Team room
	private Long teamRoom;

	// Getters & Setters
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public char getTeamPriority() {
		return teamPriority;
	}

	public void setTeamPriority(char teamPriority) {
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

}

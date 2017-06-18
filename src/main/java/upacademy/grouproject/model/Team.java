package upacademy.grouproject.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Team extends EntityModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// Team name
	@Size(min = 2, max = 30, message = "Please insert team name")
	private String teamName;
	// Professionals on the team
	@Size(min = 2, max = 30, message = "Please insert professionals names")
	private String profNames;
	// Team room
	@NotNull(message = "Please insert a room")
	private Long teamRoom;
	// Attended priority level
	@NotNull(message = "Please choose a priority")
	private String teamPriority;

	@OneToMany(targetEntity = Triage.class)
	private Collection<Triage> tickets;

	// Getters & Setters
	public Collection<Triage> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<Triage> tickets) {
		this.tickets = tickets;
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

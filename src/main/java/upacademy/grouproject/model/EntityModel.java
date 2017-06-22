package upacademy.grouproject.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class EntityModel {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long ID;

	// Getters & Setters
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

}

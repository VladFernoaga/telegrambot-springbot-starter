package ro.vladfernoaga.telegram_chatbot_starter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Type")
public class TypeInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_type")
	private Long id;

	@Column(name = "Name_type")
	private String nameType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return nameType;
	}

	public void setName(String name) {
		this.nameType = name;
	}

	@Override
	public String toString() {
		return "ModelInfo [id=" + id + ", name=" + nameType + "]";
	}

}

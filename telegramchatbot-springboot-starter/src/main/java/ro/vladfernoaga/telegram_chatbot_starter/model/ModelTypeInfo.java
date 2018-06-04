package ro.vladfernoaga.telegram_chatbot_starter.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Model_Type")
public class ModelTypeInfo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_modelType")
	private Long id;
	
	@Column(name = "Id_model")
	private String id_model;
	
	@Column(name="Id_type")
	private String id_type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getId_model() {
		return id_model;
	}

	public void setId_model(String id_model) {
		this.id_model = id_model;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	@Override
	public String toString() {
		return "ModelTypeInfo [id=" + id + ", id_model=" + id_model + ", id_type=" + id_type + "]";
	}
	
		
}

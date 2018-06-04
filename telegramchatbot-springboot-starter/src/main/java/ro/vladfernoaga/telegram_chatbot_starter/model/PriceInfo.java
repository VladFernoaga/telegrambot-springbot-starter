package ro.vladfernoaga.telegram_chatbot_starter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Price")
public class PriceInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_price")
	private Long id;
	
	@Column(name = "Id_modelType")
	private String id_modelType;
	
	@Column(name = "Id_issue")
	private String id_issue;
	
	
	@Column(name = "price")
	private String price;
	
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getId_modelType() {
		return id_modelType;
	}

	public void setId_modelType(String id_modelType) {
		this.id_modelType = id_modelType;
	}

	public String getId_issue() {
		return id_issue;
	}

	public void setId_issue(String id_issue) {
		this.id_issue = id_issue;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PriceInfo [id=" + id + ", id_modelType=" + id_modelType + ", id_issue=" + id_issue + ", price=" + price
				+ "]";
	}


	
}

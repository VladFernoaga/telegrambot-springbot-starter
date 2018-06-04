package ro.vladfernoaga.telegram_chatbot_starter.dto;

public class ModelInfoDto {
private String name;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ModelInfoDto() {
	} 
	
	public ModelInfoDto(String name) {
		super();
		this.name = name;
	} 
	
	
}

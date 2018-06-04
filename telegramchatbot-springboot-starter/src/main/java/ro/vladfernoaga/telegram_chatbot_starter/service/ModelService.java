package ro.vladfernoaga.telegram_chatbot_starter.service;

import ro.vladfernoaga.telegram_chatbot_starter.dto.BasicInfoDto;
import ro.vladfernoaga.telegram_chatbot_starter.dto.ModelInfoDto;

public interface ModelService {

	ModelInfoDto addNewOrGetExisting(String name);
}

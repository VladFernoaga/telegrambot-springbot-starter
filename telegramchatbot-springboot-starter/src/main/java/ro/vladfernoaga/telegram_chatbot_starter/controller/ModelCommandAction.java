package ro.vladfernoaga.telegram_chatbot_starter.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import ro.vladfernoaga.telegram_chatbot_starter.model.ModelInfo;
import ro.vladfernoaga.telegram_chatbot_starter.model.TypeInfo;
import ro.vladfernoaga.telegram_chatbot_starter.repo.ModelRepo;
import ro.vladfernoaga.telegram_chatbot_starter.repo.TypeRepo;

@Component
public class ModelCommandAction implements MessageCommandAction<Void> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private ModelRepo modelRepo;

	@Autowired
	private TypeRepo typeRepo;

	@Autowired
	public ModelCommandAction(ModelRepo modelRepo) {
		this.modelRepo = modelRepo;
	}

	@Override
	public Void execute(TelegramBot bot, CallbackQuery c) {
		Message m = c.message();
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();

		List<TypeInfo> types = typeRepo.findAll();

		Optional<ModelInfo> currentModel = modelRepo.findById(Long.parseLong(c.data()));
		

		InlineKeyboardButton[] buttons = new InlineKeyboardButton[types.size()];
		for (int index = 0; index < types.size(); index++) {
			buttons[index] = new InlineKeyboardButton(types.get(index).getName()).callbackData("button" + (index + 1));
		}

		InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(buttons);

		SendMessage request = new SendMessage(chatId, String.format("Pentru care tipuri de telefoane?", messageText))
				.disableNotification(false).replyToMessageId(messageId).replyMarkup(inlineKeyboard);
		bot.execute(request);

		return null;

	}

	@Override
	public Void execute(TelegramBot bot, Message m) {
		// TODO Auto-generated method stub
		return null;
	}

}

package ro.vladfernoaga.telegram_chatbot_starter.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

import ro.vladfernoaga.telegram_chatbot_starter.repo.ModelRepo;
import ro.vladfernoaga.telegram_chatbot_starter.model.ModelInfo;

@Component
public class InlineCommandAction implements MessageCommandAction<Void> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private ModelRepo modelRepo;

	@Autowired
	public InlineCommandAction(ModelRepo modelRepo) {
		this.modelRepo = modelRepo;
	}

	@Override
	public Void execute(TelegramBot bot, Message m) {
		LOGGER.info("Started repair support ... ");

		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();

		List<ModelInfo> models = modelRepo.findAll();

		LOGGER.info("Available models are: {}", models.toString());

		InlineKeyboardButton[] buttons = new InlineKeyboardButton[models.size()];
		for (int index = 0; index < models.size(); index++) {
			buttons[index] = new InlineKeyboardButton(models.get(index).getName()).callbackData("button" + (index + 1));
		}

		InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(buttons);

		/*
		 * InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup( new
		 * InlineKeyboardButton[]{ new
		 * InlineKeyboardButton("Samdung").callbackData("button1"), new
		 * InlineKeyboardButton("Huawei").callbackData("button2"), new
		 * InlineKeyboardButton("LG").callbackData("button3"), new
		 * InlineKeyboardButton("Nokia").callbackData("button4"), new
		 * InlineKeyboardButton("iPhone").callbackData("button5")
		 * 
		 * });
		 */
		SendMessage request = new SendMessage(chatId, String.format("<b>Hello inline  %s", messageText))
				.disableNotification(false).replyToMessageId(messageId).replyMarkup(inlineKeyboard);
		bot.execute(request);
		return null;
	}

}
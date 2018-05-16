package ro.vladfernoaga.telegram_chatbot_starter.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

@Service
public class StartCommandAction implements MessageCommandAction<Void> {

	public static final Logger LOGGER = LogManager.getLogger();  
	
	@Override
	public Void execute(TelegramBot bot, Message m) {
		LOGGER.info("Started action chain ... ");
		
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();

		SendMessage request = new SendMessage(chatId,
				String.format("<b>Cu ce te putem ajuta ? </b>")).parseMode(ParseMode.HTML)
						.disableNotification(false).replyToMessageId(messageId).replyMarkup(new ForceReply());
		bot.execute(request);
		
		LOGGER.info("Waiting for request ... ");
		return null;
	}

}
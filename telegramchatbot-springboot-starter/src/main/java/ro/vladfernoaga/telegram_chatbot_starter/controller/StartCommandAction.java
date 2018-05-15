package ro.vladfernoaga.telegram_chatbot_starter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class StartCommandAction implements MessageCommandAction<Void> {

	public static final Logger LOG = LoggerFactory.getLogger(StartCommandAction.class); 
	
	@Override
	public Void execute(TelegramBot bot, Message m) {
		LOG.info("Started action chain ... ");
		
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();

		SendMessage request = new SendMessage(chatId,
				String.format("<b>Cu ce te putem ajuta ? </b>")).parseMode(ParseMode.HTML)
						.disableNotification(false).replyToMessageId(messageId).replyMarkup(new ForceReply());
		bot.execute(request);
		
		LOG.info("Waiting for request ... ");
		return null;
	}

}
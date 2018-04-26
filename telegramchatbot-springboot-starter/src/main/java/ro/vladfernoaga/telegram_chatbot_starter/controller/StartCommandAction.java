package ro.vladfernoaga.telegram_chatbot_starter.controller;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public class StartCommandAction implements MessageCommandAction<Void> {

	@Override
	public Void execute(TelegramBot bot, Message m) {
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();

		SendMessage request = new SendMessage(chatId,
				String.format("<b>Cu ce te putem ajuta ? </b>")).parseMode(ParseMode.HTML)
						.disableNotification(false).replyToMessageId(messageId).replyMarkup(new ForceReply());
		bot.execute(request);
		return null;
	}

}
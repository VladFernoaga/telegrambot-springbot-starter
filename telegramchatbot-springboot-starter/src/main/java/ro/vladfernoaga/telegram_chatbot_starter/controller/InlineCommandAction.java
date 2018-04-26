package ro.vladfernoaga.telegram_chatbot_starter.controller;

import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;

@Component
public class InlineCommandAction implements MessageCommandAction<Void> {

	@Override
	public Void execute(TelegramBot bot, Message m) {
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();
		InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
		        new InlineKeyboardButton[]{
		                new InlineKeyboardButton("Samdung").callbackData("button1"),
		                new InlineKeyboardButton("Huawei").callbackData("button2"),
		                new InlineKeyboardButton("LG").callbackData("button3"),
		                new InlineKeyboardButton("Nokia").callbackData("button4"),
		                new InlineKeyboardButton("iPhone").callbackData("button5")
		   
		        });
		
		SendMessage request = new SendMessage(chatId,
				String.format("<b>Hello inline  %s", messageText))
						.disableNotification(false).replyToMessageId(messageId)
						.replyMarkup(inlineKeyboard);
		bot.execute(request);
		return null ;
	}

}
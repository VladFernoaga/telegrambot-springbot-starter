package ro.vladfernoaga.telegram_chatbot_starter.controller;



import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;

@Component
public class KeyboardAction implements MessageCommandAction<Void>{

	@Override
	public Void execute(TelegramBot bot, Message m) {
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();
		
		
		
		
		return null;
	}

	@Override
	public Void execute(TelegramBot bot, CallbackQuery m) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

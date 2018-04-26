package ro.vladfernoaga.telegram_chatbot_starter.controller;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;

public interface MessageCommandAction<T> {

	public T execute(TelegramBot bot, Message m);
}
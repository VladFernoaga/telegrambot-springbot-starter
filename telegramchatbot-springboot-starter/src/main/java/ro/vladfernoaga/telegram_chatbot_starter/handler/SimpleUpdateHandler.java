package ro.vladfernoaga.telegram_chatbot_starter.handler;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ForceReply;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

import ro.vladfernoaga.telegram_chatbot_starter.controller.FreeTextCommand;
import ro.vladfernoaga.telegram_chatbot_starter.controller.MessageCommandAction;

@Service
public class SimpleUpdateHandler implements UpdatesListener {

	/** The Constant LOGGER. */
	public static final Logger LOGGER = LogManager.getLogger();

	@Autowired
	private TelegramBot bot;

	@Autowired
	private ApplicationContext context;

	@Override
	public int process(List<Update> updates) {
		for (Update update : updates) {

			process(update);

		}

		return UpdatesListener.CONFIRMED_UPDATES_ALL;
	}

	private void process(Update u) {
		if (u.callbackQuery() != null) {
			procces(u.callbackQuery());
			return;
		}

		if (u.message() != null) {
			process(u.message());
			return;
		}
	}

	// Process free text input from user

	public void process(Message m) {
		String messageText = m.text();
		for (FreeTextCommand command : FreeTextCommand.values()) {
			if (command.getCommandText().matches(messageText)) {
				getActionInstance(command).execute(bot, m);
			}
		}
	}

	public void procces(CallbackQuery callback) {

		Message m = callback.message();
		String messageText = m.text();
		for (FreeTextCommand command : FreeTextCommand.values()) {
			if (command.getCommandText().equals(messageText)) {
				getActionInstance(command).execute(bot, callback);
			}
		}
	}

	private MessageCommandAction<?> getActionInstance(FreeTextCommand command) {
		LOGGER.info(command.name() + " " + command.getActionClass().getName());
		MessageCommandAction<?> action = (MessageCommandAction<?>) context.getBean(command.getActionClass());
		if (action == null) {
			LOGGER.warn("Could not find action bean in context");
		}
		return action;
	}

}

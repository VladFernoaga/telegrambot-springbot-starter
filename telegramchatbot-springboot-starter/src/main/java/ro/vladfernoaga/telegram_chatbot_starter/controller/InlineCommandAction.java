package ro.vladfernoaga.telegram_chatbot_starter.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	public static final Logger LOG = LoggerFactory.getLogger(InlineCommandAction.class); 
	
	@Autowired
	private ModelRepo modelRepo;
	
	@Override
	public Void execute(TelegramBot bot, Message m) {
		LOG.info("Started repair support ... ");
		
		Integer chatId = m.from().id();
		String messageText = m.text();
		Integer messageId = m.messageId();
		
		List<ModelInfo> models = modelRepo.findAll();
		
		LOG.info(models.toString());
		
		List<InlineKeyboardButton> buttons = 
				models.stream().map(e-> new InlineKeyboardButton(e.getName())).collect(Collectors.toList());
		
		InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(buttons.toArray(new InlineKeyboardButton[] {}));
		
		/*String message ;
		switch(messageText) {
		case "Samsung":
			message = "Merge";
		break;
		}*/
		
		SendMessage request = new SendMessage(chatId,
				String.format("<b>Hello inline  %s", messageText))
						.disableNotification(false).replyToMessageId(messageId)
						.replyMarkup(inlineKeyboard);
		bot.execute(request);
		return null ;
	}

}
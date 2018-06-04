package ro.vladfernoaga.telegram_chatbot_starter.controller;

public enum FreeTextCommand {

	INLINE_COMMAND("Cu o reparatie", InlineCommandAction.class), START_COMMAND("Salut",
			StartCommandAction.class), MODELS_COMMAND("Pentru care tipuri de telefoane?",
					ModelCommandAction.class);

	private String commandText;
	private Class<? extends MessageCommandAction<?>> actionClass;

	private FreeTextCommand(String commandText, Class<? extends MessageCommandAction<?>> actionClass) {
		this.commandText = commandText;
		this.actionClass = actionClass;
	}

	public String getCommandText() {
		return commandText;
	}

	public Class<? extends MessageCommandAction<?>> getActionClass() {
		return actionClass;
	}

}
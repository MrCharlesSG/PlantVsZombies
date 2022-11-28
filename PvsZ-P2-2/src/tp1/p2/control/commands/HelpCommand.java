package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class HelpCommand extends Command {

	@Override
	protected String getName() {
		return Messages.COMMAND_HELP_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_HELP_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_HELP_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_HELP_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		System.out.println(Messages.HELP_AVAILABLE_COMMANDS);
		StringBuilder buffer = new StringBuilder();
		
		for (Command c : Command.getAvailableCommands()) {
			/* @formatter:off */
			
			
			buffer.append(c.helpMessage());
			buffer.append(Messages.LINE_SEPARATOR);
			// TODO add your code here
			/* @formatter:on */
		}
		System.out.println(buffer.toString());

		return new ExecutionResult(false);
	}
	
	@Override
	public Command create(String[] parameters) {
		return this;
	}
}

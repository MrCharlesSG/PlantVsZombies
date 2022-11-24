package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class AddPlantCheatCommand extends Command {

	@Override
	protected String getName() {
		return Messages.COMMAND_CHEAT_PLANT_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_CHEAT_PLANT_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_CHEAT_PLANT_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_CHEAT_PLANT_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		return null;
	}

	@Override
	public Command create(String[] parameters) {
		Command c=new AddPlantCommand(false);
		c.create(parameters);
		return c;
	}

}

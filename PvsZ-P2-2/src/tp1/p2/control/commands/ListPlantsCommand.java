package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class ListPlantsCommand extends Command {

	@Override
	protected String getName() {
		return Messages.COMMAND_LIST_NAME;
	}
	@Override
	protected String getShortcut() {
		return Messages.COMMAND_LIST_SHORTCUT;
	}
	@Override
	public String getDetails() {
		return Messages.COMMAND_LIST_DETAILS;
	}
	@Override
	public String getHelp() {
		return Messages.COMMAND_LIST_HELP;
	}

	@Override
	public boolean execute(GameWorld game)  throws GameException {
		System.out.println(Messages.AVAILABLE_PLANTS);
		StringBuilder buffer = new StringBuilder();

		for (Plant p:PlantFactory.getAvailablePlants()) {

			buffer.append(Messages.LINE_SEPARATOR);
			buffer.append(p.getDescription());
		}
		System.out.println(buffer.toString());
		return false;
	}
}

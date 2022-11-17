package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Plant;
import tp1.p2.logic.gameobjects.PlantFactory;
import tp1.p2.view.Messages;

public class AddPlantCommand extends Command implements Cloneable {

	private int col;

	private int row;

	private String plantName;

	private boolean consumeCoins;

	public AddPlantCommand() {
		this(true);
	
	}

	public AddPlantCommand(boolean consumeCoins) {
		super();
		this.consumeCoins = consumeCoins;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_HELP;
	}

	@Override
	public ExecutionResult execute(GameWorld game) {
		
		Plant aux=PlantFactory.spawnPlant(plantName, game, col, row);
		if(aux!= null) {
			game.addObj(aux);
		}
		game.update();
		return new ExecutionResult(true);
	}

	@Override
	public Command create(String[] parameters) {
		if(parameters.length==4) {
			this.row=stringToInt(parameters[3]);
			this.col=stringToInt(parameters[2]);
			this.plantName=parameters[1].toLowerCase();
			return this;
		}
		
		return null;
	}

}
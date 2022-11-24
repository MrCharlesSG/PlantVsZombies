package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.GameObject;
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
		
		GameObject aux=PlantFactory.spawnPlant(plantName, game, col, row, consumeCoins);
		if(aux!= null) {
			game.addItem(aux);
			game.update();
			return new ExecutionResult(true);
		}
		return new ExecutionResult(false);
	}

	@Override
	public Command create(String[] parameters) {
		if(parameters.length==4) {
			if(isNumeric(parameters[2]) && this.isNumeric(parameters[3])) {
				this.row=Integer.parseInt(parameters[3]);
				this.col=Integer.parseInt(parameters[2]);
				if(!isNumeric(parameters[1])) {
					this.plantName=parameters[1].toLowerCase();
					return this;
				}
			}
		}
		
		return null;
	}

}
package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.exceptions.CommandExecuteException;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.GameWorld;
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
	public boolean execute(GameWorld game)  throws GameException {
		try{
			game.addItem(PlantFactory.spawnPlant(plantName, game, col, row, consumeCoins));
			game.update();
			return true;
		}catch(CommandExecuteException e){
			throw e;
		}
		
	}

	@Override
	public Command create(String[] parameters) throws GameException  {
		try {	
			this.row=Integer.parseInt(parameters[3]);
			this.col=Integer.parseInt(parameters[2]);
			this.plantName=parameters[1].toLowerCase();
			
			if(!PlantFactory.isValidPlant(plantName)) {
				throw new CommandParseException(Messages.INVALID_GAME_OBJECT);
			}else {
				return this;
			}
		}catch(NumberFormatException e) {
			throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER, e);
		}
	}
}
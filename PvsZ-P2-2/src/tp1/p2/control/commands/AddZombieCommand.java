package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.exceptions.CommandExecuteException;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.ZombieFactory;
import tp1.p2.view.Messages;

public class AddZombieCommand extends Command {

	private int zombieIdx;

	private int col;

	private int row;

	public AddZombieCommand() {

	}
/*
	private AddZombieCommand(int zombieIdx, int col, int row) {
		this.zombieIdx = zombieIdx;
		this.col = col;
		this.row = row;
	}
*/
	@Override
	protected String getName() {
		return Messages.COMMAND_ADD_ZOMBIE_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_ADD_ZOMBIE_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_ADD_ZOMBIE_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_ADD_ZOMBIE_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException  {
		try {
			game.addItem(ZombieFactory.spawnZombie(row,col, game, zombieIdx));
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
			this.zombieIdx=Integer.parseInt(parameters[1]);
			
			if(ZombieFactory.getAvailableZombies().size()<=this.zombieIdx) {
				throw new CommandParseException(Messages.INVALID_GAME_OBJECT);
			}else {
				return this;
			}
		} catch(NumberFormatException e) {
			throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER, e);
		}
	}

}

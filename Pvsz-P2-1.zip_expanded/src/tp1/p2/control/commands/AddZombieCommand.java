package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.logic.gameobjects.ZombieFactory;
import tp1.p2.view.Messages;

public class AddZombieCommand extends Command {

	private int zombieIdx;

	private int col;

	private int row;

	public AddZombieCommand() {

	}

	private AddZombieCommand(int zombieIdx, int col, int row) {
		this.zombieIdx = zombieIdx;
		this.col = col;
		this.row = row;
	}

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
	public ExecutionResult execute(GameWorld game) {
		GameObject aux= ZombieFactory.spawnZombie(row,col, game, zombieIdx);
		if(aux!=null) {
			game.addItem(aux);
			game.update();
			return new ExecutionResult(true);
		}
		return new ExecutionResult(false);
	}

	@Override
	public Command create(String[] parameters) {
		if(parameters.length==4) {
			this.row=Integer.parseInt(parameters[3]);
			this.col=Integer.parseInt(parameters[2]);
			this.zombieIdx=Integer.parseInt(parameters[1]);
			return this;
		}
		return null;
	}

}

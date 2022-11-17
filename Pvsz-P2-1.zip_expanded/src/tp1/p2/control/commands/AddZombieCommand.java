package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.logic.GameWorld;
import tp1.p2.logic.gameobjects.Zombie;
import tp1.p2.logic.gameobjects.ZombieFactory;
import tp1.p2.view.Messages;

public class AddZombieCommand extends Command implements Cloneable{
	
	private int zombieType;
	
	private String zombieName;

	private int row;

	public AddZombieCommand() {
		super();
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
		
		Zombie aux = ZombieFactory.spawnZombie(row, game, zombieType);
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
			this.zombieName=parameters[1].toLowerCase();
			return this;
		}
		
		return null;
	}

	
}

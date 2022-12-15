package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.exceptions.CommandExecuteException;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class CatchCommand extends Command {

	private static boolean caughtSunThisCycle = false;

	private int col;

	private int row;

	public CatchCommand() {
		caughtSunThisCycle = false;
	}
	
	@Override
	protected void newCycleStarted() {
		caughtSunThisCycle = false;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_CATCH_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_CATCH_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_CATCH_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_CATCH_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException {
		if(!caughtSunThisCycle) {
			try {
				game.tryToCatchObject(col, row);
				caughtSunThisCycle=true;
				
				return true;
			}catch(GameException e) {
				throw new CommandExecuteException(e);
			}
		}else {
			throw new CommandExecuteException(Messages.SUN_ALREADY_CAUGHT);
		}
	}

	@Override
	public Command create(String[] parameters)throws GameException {
		try {
			if(parameters.length==3) {
				this.row=Integer.parseInt(parameters[2]);
				this.col=Integer.parseInt(parameters[1]);
				return this;
			}else {
				throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
			}
			
		}catch(NumberFormatException e) {
			throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER, e);
		}
	}



}

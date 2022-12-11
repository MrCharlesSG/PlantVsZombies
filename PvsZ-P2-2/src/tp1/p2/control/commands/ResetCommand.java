package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

public class ResetCommand extends Command {

	private Level level;

	private long seed;

	public ResetCommand() {
		level=null;
		seed=-1;
	}

	public ResetCommand(Level level, long seed) {
		this.level = level;
		this.seed = seed;
	}

	@Override
	protected String getName() {
		return Messages.COMMAND_RESET_NAME;
	}

	@Override
	protected String getShortcut() {
		return Messages.COMMAND_RESET_SHORTCUT;
	}

	@Override
	public String getDetails() {
		return Messages.COMMAND_RESET_DETAILS;
	}

	@Override
	public String getHelp() {
		return Messages.COMMAND_RESET_HELP;
	}

	@Override
	public boolean execute(GameWorld game) throws GameException{
		if(level==null) {
			game.reset();
		}else {
			game.reset(level, seed);
		}
		return true;
	}

	@Override
	public Command create(String[] parameters)  throws GameException {
		if(parameters.length==3) {
			
			Level level=Level.valueOfIgnoreCase(parameters[1]);
			if(level!=null) {
				try {
					Long seed = Long.parseLong(parameters[2]);
					return new ResetCommand(level, seed);	
				}catch(NumberFormatException e) {
					throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER, e);
				}
			}
			throw new CommandParseException();
		}else {
			return new ResetCommand();
		}
	}
	
}
package tp1.p2.control.commands;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
import tp1.p2.control.Level;
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
	public ExecutionResult execute(GameWorld game){
		if(level==null) {
			game.reset();
		}else {
			game.reset(level, seed);
		}
		return new ExecutionResult(true);
	}

	@Override
	public Command create(String[] parameters) {
		if(parameters.length>1) {
			Level level=Level.valueOfIgnoreCase(parameters[0]);
			if(level!=null) {
				Long seed = Long.parseLong(parameters[1]);
				return new ResetCommand(level, seed);				
			}
		}else {
			return new ResetCommand();
		}
		return null;
	}

}
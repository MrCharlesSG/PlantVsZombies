package tp1.p2.control.commands;

import tp1.p2.control.Command;
import tp1.p2.control.ExecutionResult;
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
	public ExecutionResult execute(GameWorld game) {
		if(!caughtSunThisCycle) {
			if(game.catchSun(this.col, this.row)) {
				caughtSunThisCycle=true;
				return new ExecutionResult(true);
			}else {
				GameWorld.notSunInPosition(col, row);
			}
		}
		return new ExecutionResult(false);
	}

	@Override
	public Command create(String[] parameters) {
		if(parameters.length==3) {
			if(isNumeric(parameters[2]) && this.isNumeric(parameters[1])) {
				this.row=Integer.parseInt(parameters[2]);
				this.col=Integer.parseInt(parameters[1]);
				if(this.validPosition(col, row)) {
					return this;
				}else {
					
					GameWorld.invalidPosition();
					
					return null;
				}
				
			}else {
				GameWorld.invalidPosition();
			}
			
		}else {
			GameWorld.incorerectParameterNumber();
		}
		
		return null;
	}



}

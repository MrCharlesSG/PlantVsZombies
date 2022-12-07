package tp1.p2.control;

import static tp1.p2.view.Messages.error;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tp1.p2.control.commands.AddPlantCheatCommand;
import tp1.p2.control.commands.AddPlantCommand;
import tp1.p2.control.commands.AddZombieCommand;
import tp1.p2.control.commands.CatchCommand;
import tp1.p2.control.commands.ExitCommand;
import tp1.p2.control.commands.HelpCommand;
import tp1.p2.control.commands.ListPlantsCommand;
import tp1.p2.control.commands.ListZombiesCommand;
import tp1.p2.control.commands.NoneCommand;
import tp1.p2.control.commands.ResetCommand;
import tp1.p2.control.commands.ShowRecordCommand;
import tp1.p2.control.exceptions.CommandParseException;
import tp1.p2.control.exceptions.GameException;
import tp1.p2.logic.GameWorld;
import tp1.p2.view.Messages;

/**
 * Represents a user action in the game.
 *
 */
public abstract class Command {

	/* @formatter:off */
	private static final List<Command> AVAILABLE_COMMANDS = Arrays.asList(
		new AddPlantCommand(),
		new ListPlantsCommand(),
		new ResetCommand(),
		new HelpCommand(),
		new ExitCommand(),
		new NoneCommand(),
		new ListZombiesCommand(),
		new AddZombieCommand(),
		new AddPlantCheatCommand(),
		new CatchCommand(),
		new ShowRecordCommand()
	);
	/* @formatter:on */

	private static Command defaultCommand;

	public static Command parse(String[] commandWords) throws GameException  {
		//return none
		if (commandWords.length == 1 && commandWords[0].isEmpty()) {
			return new NoneCommand();
		}
		//return otros
		for (Command command : AVAILABLE_COMMANDS) {
			if (command.matchCommand(commandWords[0])) {
				return command.create(commandWords);//
			}
		}
		throw new CommandParseException(Messages.UNKNOWN_COMMAND);
	}

	public static Iterable<Command> getAvailableCommands() {
		return Collections.unmodifiableList(AVAILABLE_COMMANDS);
	}

	public static void newCycle() {
		for(Command c : AVAILABLE_COMMANDS) {
			c.newCycleStarted();
		}
	}

	public Command() {
		this(false);
	}

	public Command(boolean isDefault) {
		if (isDefault) {
			// TODO add your code here
		}
	}

	abstract protected String getName();

	abstract protected String getShortcut();

	abstract public String getDetails();

	abstract public String getHelp();

	public String helpMessage() {
		StringBuilder buffer=new StringBuilder(this.getDetails());
		buffer.append(": ");
		buffer.append(this.getHelp());
		return buffer.toString();
	}
	
	public boolean isDefaultCommand() {
		return Command.defaultCommand == this;
	}

	public boolean matchCommand(String token) {
		String shortcut = getShortcut();
		String name = getName();
		return shortcut.equalsIgnoreCase(token) || name.equalsIgnoreCase(token)
				|| (isDefaultCommand() && "".equals(token));
	}

	/**
	 * Execute the command.
	 * 
	 * @param game Where to execute the command.
	 * 
	 * @return {@code true} if game board must be printed {@code false} otherwise.
	 */
	public abstract boolean execute(GameWorld game) throws GameException;

	public Command create(String[] parameters) throws GameException {
		if (parameters.length != 0) {
			throw new CommandParseException(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER);
		}
		return this;
	}
	
	

	/**
	 * Notifies the {@link Command} that a new cycle has started.
	 */
	protected void newCycleStarted() {
		
	}
	
	protected boolean isNumeric(String str) {
		return  str!= null && str.matches("[0-9.]+");
	}
	
	protected boolean validPosition(int col, int row) {
		return col<GameWorld.NUM_COLS && row <GameWorld.NUM_ROWS && col>=0 && row>=0;
	}
}
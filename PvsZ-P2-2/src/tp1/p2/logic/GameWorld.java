package tp1.p2.logic;

import static tp1.p2.view.Messages.error;

import tp1.p2.control.Command;
import tp1.p2.control.Level;
import tp1.p2.logic.actions.GameAction;
import tp1.p2.logic.gameobjects.GameObject;
import tp1.p2.view.Messages;

public interface GameWorld {

	public static final int NUM_ROWS = 4;

	public static final int NUM_COLS = 8;


    void playerQuits();

    void update();
    
    boolean execute(Command command);
	
	void addItem(GameObject obj);
	
	boolean esSuficiente(int coste);

	void reset(Level level, long seed);
	
	void reset() ;
	
	GameObject isInPosition(int col, int row);
		
	void generaSunCoins();
	
	void reduceZombie();

	void zombiesWin();

	boolean playerWin();

	GameItem getGameItemInPosition(int col, int row);
	
	public int getCycle();

	boolean catchSun(int col, int row);

	void convertSun(int valueOfChange);

	void pushAction(GameAction gameAction);
	
	boolean isFullyOcuppied(int col, int row);

	static void incorerectParameterNumber() {
		System.out.println(error(Messages.COMMAND_INCORRECT_PARAMETER_NUMBER));
	}
	
	static void unknownCommand() {
		System.out.println(error(Messages.UNKNOWN_COMMAND));
	}
	
	static void invalidCommand() {
		System.out.println(error(Messages.INVALID_COMMAND));
	}
	
	static void invalidPosition() {
		System.out.println(error(Messages.INVALID_POSITION));
	}
	
	static void invalidGObject() {
		System.out.println(error(Messages.INVALID_GAME_OBJECT));
	}
	
	static void notEnoughtSuncoins() {
		System.out.println(error(Messages.NOT_ENOUGH_COINS));
	}
	
	static void notSunInPosition(int col, int row) {
		System.out.println(error(Messages.NO_CATCHABLE_IN_POSITION.formatted(col, row)));
	}
	
	static void notAllowedLevel() {
		System.out.println(error("Invalid Level"));
		System.out.println(error(Messages.ALLOWED_LEVELS));
	}
}
